package com.example.rnm_mvvm.repositories

import com.example.rnm_mvvm.model.Character
import com.example.rnm_mvvm.model.RnmReturn
import com.example.rnm_mvvm.networkService.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CharacterRepository {

    fun getCharacter(): Flow<RnmReturn> = flow {
        val r = RetrofitClient.retrofit.getDataList()
        emit(r)
    }.flowOn(Dispatchers.IO)
}