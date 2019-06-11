package com.example.coinmarketproject.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.FragmentManager
import com.example.coinmarketproject.MainApplication
import com.example.coinmarketproject.ui.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideContext(app: MainApplication): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    fun provideDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("Default", Context.MODE_PRIVATE)
    }

//    @Singleton
//    @Provides
//    fun provideFragmentManager(mainActivity: MainActivity): FragmentManager {
//        return mainActivity.supportFragmentManager
//    }
}