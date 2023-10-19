package com.example.rnm_mvvm

import android.app.Application
import com.example.rnm_mvvm.di.AppModule
import com.example.rnm_mvvm.di.CharacterRepositoryComponent
import com.example.rnm_mvvm.di.DaggerCharacterRepositoryComponent
import com.example.rnm_mvvm.networkService.NetModule
import com.example.rnm_mvvm.networkService.AllApi
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    private lateinit var charcterRepositoryComponent: CharacterRepositoryComponent

    override fun onCreate() {
        super.onCreate()
        charcterRepositoryComponent =
            DaggerCharacterRepositoryComponent.builder().appModule(AppModule(this))
                .netModule(NetModule(AllApi.BASE_URL)).build()

    }

    fun getCharacterRepositoryComponent(): CharacterRepositoryComponent {
        return charcterRepositoryComponent
    }


}