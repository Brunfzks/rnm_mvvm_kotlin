package com.example.rnm_mvvm.model

import com.google.gson.annotations.SerializedName


data class RnmReturn (

    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<Character> = arrayListOf()

)