package com.example.local.datasource

import android.content.SharedPreferences
import androidx.annotation.VisibleForTesting
import com.example.data.datasource.ICurrencyInfoLocalDataSource
import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.model.CurrencyInfo
import com.example.local.database.CoinMarketDataBase
import com.example.local.mapper.toCurrencyInfoEntityList
import com.example.local.mapper.toCurrencyInfoList
import io.reactivex.Single


class CurrencyInfoLocalDataSource(
    private val coinMarketDataBase: CoinMarketDataBase,
    private val currencyInfoRemoteDataSource: ICurrencyInfoRemoteDataSource,
    private val sharedPreferences: SharedPreferences
) : ICurrencyInfoLocalDataSource {

    override fun getLatest(): Single<List<CurrencyInfo>> {
        val getTimeIntervalFromLastTime = getTimeIntervalFromLastTime()

        if (getTimeIntervalFromLastTime < PERIOD_TIME_FOR_GET_FROM_REMOTE_IN_MILLIS) {
            return coinMarketDataBase.currencyInfoDao().getAll().map { it.toCurrencyInfoList() }
                .flatMap { currencyInfoList: List<CurrencyInfo> ->
                    if (currencyInfoList.isNotEmpty()) {
                        return@flatMap Single.just(currencyInfoList)
                    } else {
                        return@flatMap getLatestFromRemote()
                    }
                }
        } else {
            return getLatestFromRemote()
        }

    }

    @VisibleForTesting
    fun getLatestFromRemote(): Single<List<CurrencyInfo>> {
        return currencyInfoRemoteDataSource.getLatest()
            .map {
                addCurrencyInfoList(it)
                it
            }
    }

    override fun addCurrencyInfoList(currencyInfoList: List<CurrencyInfo>) {
        saveLastGetLatestTime()
        coinMarketDataBase.currencyInfoDao().insert(currencyInfoList.toCurrencyInfoEntityList())
    }

    fun getTimeIntervalFromLastTime(): Long {
        val currentTimeMillis = System.currentTimeMillis()
        val lastGetTime = sharedPreferences.getLong(LAST_GET_LATEST_TIME, currentTimeMillis)
        return currentTimeMillis - lastGetTime
    }

    @VisibleForTesting
    fun saveLastGetLatestTime(time: Long = System.currentTimeMillis()) {
        sharedPreferences
            .edit()
            .putLong(LAST_GET_LATEST_TIME, time)
            .apply()
    }

    companion object {
        const val PERIOD_TIME_FOR_GET_FROM_REMOTE_IN_MILLIS: Long = 300000
        const val LAST_GET_LATEST_TIME = "last_get_latest_time"
    }
}