package com.example.coinmarketproject.di

import com.example.coinmarketproject.di.module.*
import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import com.example.coinmarketproject.ui.service.FirstAndLastCoinPriceService
import dagger.Component
import javax.inject.Singleton

@Singleton
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
    fun inject(firstAndLastCoinPriceService: FirstAndLastCoinPriceService)
}