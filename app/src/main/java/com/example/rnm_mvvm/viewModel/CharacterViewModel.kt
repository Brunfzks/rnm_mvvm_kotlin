package com.example.rnm_mvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rnm_mvvm.model.RnmReturn
import com.example.rnm_mvvm.networkService.ApiState
import com.example.rnm_mvvm.repositories.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CharacterViewModel (private var repository: CharacterRepository): ViewModel(){
    val wMessage: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
    private  var dataAux = RnmReturn()
    private  var page = 1

    var items = RnmReturn()
    fun getAllCharacter() {

        viewModelScope.launch {
            wMessage.value = ApiState.Loading

            repository.getCharacter(page = page)
                .catch { e ->
                    wMessage.value = ApiState.Failure(e)
                }.collect { data ->
                    dataAux.info = data.info
                    dataAux.results.addAll(data.results)
                }

            if (dataAux.info?.next.isNullOrBlank()) {
                wMessage.value = ApiState.Success(dataAux)
                dataAux = RnmReturn()
            } else {
                page++
                getAllCharacter()
            }

        }

    }
    fun getCharacter() {

        viewModelScope.launch {
            wMessage.value = ApiState.Loading

            repository.getCharacter(page = page)
                .catch { e ->
                    wMessage.value = ApiState.Failure(e)
                }.collect { data ->
                    dataAux.info = data.info
                    dataAux.results.addAll(data.results)
                    dataAux.results.addAll(items.results)
                    wMessage.value = ApiState.Success(dataAux)
                    page++
                    dataAux = RnmReturn()
                }

        }
    }

}