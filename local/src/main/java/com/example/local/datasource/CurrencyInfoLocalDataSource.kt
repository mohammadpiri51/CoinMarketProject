package com.example.local.datasource

import android.content.SharedPreferences
import com.example.data.datasource.ICurrencyInfoLocalDataSource
import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.model.CurrencyInfo
import com.example.local.database.CoinMarketDataBase
import com.example.local.mapper.toCurrencyInfoEntityList
import com.example.local.mapper.toCurrencyInfoList
import io.reactivex.Single
import java.util.concurrent.TimeUnit


class CurrencyInfoLocalDataSource(
    private val coinMarketDataBase: CoinMarketDataBase,
    private val currencyInfoRemoteDataSource: ICurrencyInfoRemoteDataSource,
    private val sharedPreferences: SharedPreferences
) :
    ICurrencyInfoLocalDataSource {

    override fun getLatest(): Single<List<CurrencyInfo>> {
        val lastGetTime = sharedPreferences.getLong(LAST_GET_LATEST_TIME, System.currentTimeMillis())
        val diffInMs = System.currentTimeMillis() - lastGetTime
        val diffInMin = TimeUnit.MILLISECONDS.toMinutes(diffInMs)
        if (diffInMin < 2) {
            return coinMarketDataBase.currencyInfoDao().getAll().map { it.toCurrencyInfoList() }
                .flatMap { localList: List<CurrencyInfo> ->
                    if (localList.isNotEmpty()) {
                        return@flatMap Single.just(localList)
                    } else {
                        return@flatMap getLatestFromRemote()
                    }
                }
        } else {
            return getLatestFromRemote()
        }

    }

    private fun getLatestFromRemote(): Single<List<CurrencyInfo>> {
        return currencyInfoRemoteDataSource.getLatest()
            .map {
                addCurrencyInfoList(it)
                it
            }
    }

    override fun addCurrencyInfoList(currencyInfoList: List<CurrencyInfo>) {
        sharedPreferences
            .edit()
            .putLong(LAST_GET_LATEST_TIME, System.currentTimeMillis())
            .apply()
        coinMarketDataBase.currencyInfoDao().insert(currencyInfoList.toCurrencyInfoEntityList())
    }

    companion object {
        const val LAST_GET_LATEST_TIME = "last_get_latest_time"
    }
}