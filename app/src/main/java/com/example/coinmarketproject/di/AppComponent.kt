package com.example.coinmarketproject.di

import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(currencyInfoFragment: CurrencyInfoFragment)
}