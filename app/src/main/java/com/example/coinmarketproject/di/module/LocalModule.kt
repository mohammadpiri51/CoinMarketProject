package com.example.coinmarketproject.di.module

import android.content.Context
import androidx.room.Room
import com.example.local.database.CoinMarketDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {
    @Provides
    @Singleton
    fun provideCoinMarketDatabase(context: Context): CoinMarketDataBase {
        return Room.databaseBuilder(context, CoinMarketDataBase::class.java, "db.CoinMarket").build()
    }
}