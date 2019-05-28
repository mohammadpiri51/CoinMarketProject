package com.example.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.local.dao.CurrencyInfoDao
import com.example.local.entity.CurrencyInfoEntity

@Database(entities = [CurrencyInfoEntity::class], version = 1)
abstract class CoinMarketDataBase :RoomDatabase(){

    abstract fun currencyInfoDao():CurrencyInfoDao
}