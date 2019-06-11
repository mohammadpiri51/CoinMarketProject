package com.example.coinmarketproject.di.module

import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import com.example.coinmarketproject.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun currencyInfoFragment(): CurrencyInfoFragment

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

}
