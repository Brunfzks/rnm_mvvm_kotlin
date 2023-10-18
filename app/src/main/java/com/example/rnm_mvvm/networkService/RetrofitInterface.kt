package com.example.rnm_mvvm.networkService

import com.example.rnm_mvvm.model.Character
import com.example.rnm_mvvm.model.RnmReturn
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET(AllApi.DATA_LIST)
    fun getDataList(@Query(AllApi.PAGE)page: Int): Observable<RnmReturn>
}