package com.example.rnm_mvvm.repositories

import com.example.rnm_mvvm.model.RnmReturn
import com.example.rnm_mvvm.networkService.RetrofitInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import javax.inject.Inject

class CharacterRepository @Inject constructor(private var retrofit: Retrofit) {

    fun getCharacter(page:Int): Flow<RnmReturn> = flow {
        val r = retrofit.create(RetrofitInterface::class.java).getDataList(page)
        emit(r)
    }.flowOn(Dispatchers.IO)
}