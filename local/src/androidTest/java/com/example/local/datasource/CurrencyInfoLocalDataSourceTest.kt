package com.example.local.datasource

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.MediumTest
import androidx.test.runner.AndroidJUnit4
import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.model.CurrencyInfo
import com.example.data.model.Platform
import com.example.data.model.Quote
import com.example.data.model.Usd
import com.example.local.database.CoinMarketDataBase
import com.example.local.datasource.CurrencyInfoLocalDataSource.Companion.PERIOD_TIME_FOR_GET_FROM_REMOTE_IN_MILLIS
import com.example.local.mapper.toCurrencyInfo
import com.example.local.mapper.toCurrencyInfoEntity
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

@MediumTest
@RunWith(AndroidJUnit4::class)
class CurrencyInfoLocalDataSourceTest {

    private lateinit var coinMarketDataBase: CoinMarketDataBase
    private lateinit var currencyInfoRemoteDataSource: ICurrencyInfoRemoteDataSource
    private lateinit var defaultSharedPreferences: SharedPreferences
    private lateinit var currencyInfoLocalDataSource: CurrencyInfoLocalDataSource

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        defaultSharedPreferences = context.getSharedPreferences("Default", Context.MODE_PRIVATE)
        coinMarketDataBase = Room.inMemoryDatabaseBuilder(context, CoinMarketDataBase::class.java).build()
        currencyInfoRemoteDataSource = mockk()
        currencyInfoLocalDataSource =
            CurrencyInfoLocalDataSource(coinMarketDataBase, currencyInfoRemoteDataSource, defaultSharedPreferences)
    }

    @After
    fun tearDown() {
        coinMarketDataBase.clearAllTables()
        coinMarketDataBase.close()
        defaultSharedPreferences.clear()
    }

    @Test
    fun getLatest_first_time() {
        val sampleResultList = listOf(randomCurrencyInfo())

        every { currencyInfoRemoteDataSource.getLatest() } returns Single.just(sampleResultList)

        assertEquals(0, currencyInfoLocalDataSource.getTimeIntervalFromLastTime())

        currencyInfoLocalDataSource.getLatest()
            .test()
            .assertComplete()
            .assertResult(sampleResultList)

    }

    @Test
    fun getLatest_after_specified_time_interval() {
        val sampleResultList = listOf(randomCurrencyInfo(), randomCurrencyInfo())
        currencyInfoLocalDataSource.saveLastGetLatestTime(System.currentTimeMillis() - (PERIOD_TIME_FOR_GET_FROM_REMOTE_IN_MILLIS + 1))
        every { currencyInfoRemoteDataSource.getLatest() } returns Single.just(sampleResultList)
        currencyInfoLocalDataSource.getLatest()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertResult(sampleResultList)
    }

    @Test
    fun getLatest_before_specified_time_interval() {
        val sampleList = listOf(randomCurrencyInfo())
        val expectedResultList = sampleList.map { it.toCurrencyInfoEntity() }.map { it.toCurrencyInfo() }
        currencyInfoLocalDataSource.addCurrencyInfoList(sampleList)

        currencyInfoLocalDataSource.getLatest()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertResult(expectedResultList)
    }


    @Test
    fun addCurrencyInfoList() {
    }

    fun SharedPreferences.clear() {
        val edit = edit()
        all.forEach { (k, _) ->
            edit.remove(k)
        }
        edit.commit()
    }

    fun randomCurrencyInfo(): CurrencyInfo = CurrencyInfo(
        id = Random.nextInt(),
        name = Random.nextInt().toString(),
        price = Random.nextDouble(),
        slug = Random.nextInt().toString(),
        symbol = Random.nextInt().toString(),
        iconUrl = Random.nextInt().toString(),
        platform = Platform(
            id = Random.nextInt(),
            name = Random.nextInt().toString(),
            symbol = Random.nextInt().toString(),
            slug = Random.nextInt().toString(),
            tokenAddress = Random.nextInt().toString()
        ),
        quote = Quote(
            usd = Usd(
                lastUpdated = Random.nextInt().toString(),
                price = Random.nextDouble(),
                volume24h = Random.nextDouble(),
                percentChange24h = Random.nextDouble(),
                percentChange7d = Random.nextDouble(),
                percentChange1h = Random.nextDouble(),
                marketCap = Random.nextDouble()
            )
        )
    )
}