package com.example.coinmarketproject.di.module

import androidx.lifecycle.ViewModel
import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoViewModel
import com.example.coinmarketproject.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CurrencyInfoViewModel::class)
    abstract fun bindMyViewModel(currencyInfoViewModel: CurrencyInfoViewModel): ViewModel
}