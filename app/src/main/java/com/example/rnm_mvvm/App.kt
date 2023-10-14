package com.example.rnm_mvvm

import android.app.Application
import com.getkeepsafe.relinker.ReLinker
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        ReLinker.loadLibrary(this, "native-lib")

    }

}