package com.example.rnm_mvvm.networkService

import com.example.rnm_mvvm.model.Character
import com.example.rnm_mvvm.model.RnmReturn
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET(AllApi.DATA_LIST)
    suspend fun getDataList(@Query(AllApi.PAGE)page: Int): RnmReturn
}