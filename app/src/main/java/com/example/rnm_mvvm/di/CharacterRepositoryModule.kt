package com.example.rnm_mvvm.di

import android.app.Application
import com.example.rnm_mvvm.repositories.CharacterRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
@Module
class CharacterRepositoryModule {
    @Provides
    @Singleton
    fun provideCharacterRepositoryModule(retrofit: Retrofit): CharacterRepository {
        return CharacterRepository(retrofit)
    }
}