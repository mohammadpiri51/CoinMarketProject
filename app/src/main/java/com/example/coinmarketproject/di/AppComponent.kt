package com.example.coinmarketproject.di

import com.example.coinmarketproject.MainApplication
import com.example.coinmarketproject.di.module.*
import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import com.example.coinmarketproject.ui.home.HomeFragment
import com.example.coinmarketproject.ui.service.FirstAndLastCoinPriceService
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        FragmentsModule::class,
        ServicesModule::class,
        ActivitiesModule::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        RemoteModule::class,
        LocalModule::class,
        DataModule::class]
)

interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MainApplication>
}