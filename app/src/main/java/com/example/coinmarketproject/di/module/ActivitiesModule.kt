package com.example.coinmarketproject.di.module

import com.example.coinmarketproject.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}
