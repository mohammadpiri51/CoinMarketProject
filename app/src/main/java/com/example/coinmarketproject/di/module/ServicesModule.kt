package com.example.coinmarketproject.di.module

import com.example.coinmarketproject.ui.service.FirstAndLastCoinPriceService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServicesModule {

    @ContributesAndroidInjector
    abstract fun firstAndLastCoinPriceService(): FirstAndLastCoinPriceService

}
