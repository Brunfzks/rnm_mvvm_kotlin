package com.example.rnm_mvvm.di

import com.example.rnm_mvvm.networkService.NetModule
import com.example.rnm_mvvm.ui.fragment.ItemFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface CharacterRepositoryComponent {
    fun inject(fragment: ItemFragment)
}