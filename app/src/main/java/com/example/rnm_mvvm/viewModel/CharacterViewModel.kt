package com.example.rnm_mvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rnm_mvvm.networkService.ApiState
import com.example.rnm_mvvm.repositories.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CharacterViewModel (private var repository: CharacterRepository): ViewModel(){
    val wMessage: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    fun getCharacter() = viewModelScope.launch {
        wMessage.value = ApiState.Loading
        repository.getCharacter()
            .catch { e ->
                wMessage.value = ApiState.Failure(e)
            }.collect { data ->
                wMessage.value = ApiState.Success(data)
            }
    }

}