package com.example.rnm_mvvm.networkService

import com.example.rnm_mvvm.model.Character
import com.example.rnm_mvvm.model.RnmReturn
import retrofit2.http.GET

interface RetrofitInterface {
    @GET(AllApi.DATA_LIST)
    suspend fun getDataList(): RnmReturn
}