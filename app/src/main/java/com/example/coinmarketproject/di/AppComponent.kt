package com.example.coinmarketproject.di

import com.example.coinmarketproject.di.module.*
import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import dagger.Component

@Component(
    modules = [AppModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        RemoteModule::class,
        DataModule::class,
        LocalModule::class]
)
interface AppComponent {
    fun inject(currencyInfoFragment: CurrencyInfoFragment)
}