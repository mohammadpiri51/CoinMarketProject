package com.example.coinmarketproject.di

import com.example.coinmarketproject.di.module.DataModule
import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import com.example.coinmarketproject.di.module.RemoteModule
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class, RemoteModule::class, DataModule::class])
interface AppComponent {
    fun inject(currencyInfoFragment: CurrencyInfoFragment)
}