package com.example.rnm_mvvm.networkService

object AllApi {

    private external fun baseUrlFromJNI(boolean: Boolean): String

    const val BASE_URL = "https://rickandmortyapi.com/api/"

    const val PAGE = "page"

    const val DATA_LIST = "character/"

}