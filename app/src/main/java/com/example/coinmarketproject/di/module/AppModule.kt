package com.example.coinmarketproject.di.module

import android.content.Context
import com.example.coinmarketproject.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: MainApplication) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return app.applicationContext
    }
}