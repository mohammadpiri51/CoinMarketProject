package com.example.coinmarketproject.di

import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import com.example.coinmarketproject.di.module.RemoteModule
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class, RemoteModule::class])
interface AppComponent {
    fun inject(currencyInfoFragment: CurrencyInfoFragment)
}