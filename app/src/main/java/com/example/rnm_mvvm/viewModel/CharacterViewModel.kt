package com.example.rnm_mvvm.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rnm_mvvm.model.RnmReturn
import com.example.rnm_mvvm.networkService.ApiState
import com.example.rnm_mvvm.repositories.CharacterRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CharacterViewModel(private var repository: CharacterRepository) : ViewModel() {
    var page = 1

    var items = RnmReturn()
    fun getCharacter(): Observable<RnmReturn> {

        return repository.getCharacter(page = page)
            .map {
                it
            }.doOnComplete {
                page++
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


}