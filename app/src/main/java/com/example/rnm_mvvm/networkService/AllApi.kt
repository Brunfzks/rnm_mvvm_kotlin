package com.example.rnm_mvvm.networkService

object AllApi {

    private external fun baseUrlFromJNI(boolean: Boolean): String

    const val BASE_URL = "https://rickandmortyapi.com/api/"

    private const val V1 = ""

    const val DATA_LIST = V1 + "character/"

}