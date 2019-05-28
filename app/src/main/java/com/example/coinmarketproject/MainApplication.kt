package com.example.coinmarketproject

import android.app.Application
import com.example.coinmarketproject.di.AppComponent
import com.example.coinmarketproject.di.DaggerAppComponent
import com.example.coinmarketproject.di.module.AppModule

class MainApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}