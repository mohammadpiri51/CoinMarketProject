package com.example.data.repository

import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.entity.CurrencyInfoEntity
import com.example.data.entity.PlatformEntity
import com.example.data.entity.QuoteEntity
import com.example.data.entity.UsdEntity
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class CurrencyInfoRepositoryTest {

    private val currencyInfoRemoteDataSource: ICurrencyInfoRemoteDataSource = mockk()
    private val currencyInfoRepository = CurrencyInfoRepository(currencyInfoRemoteDataSource)
    private val currencyInfoEntityList = listOf(
        CurrencyInfoEntity(
            name = "1",
            symbol = "2",
            slug = "3",
            quote = QuoteEntity(
                UsdEntity(
                    lastUpdated = "",
                    marketCap = 1.0,
                    percentChange1h = 2.0,
                    percentChange7d = 3.0,
                    percentChange24h = 4.0,
                    price = 5.0,
                    volume24h = 6.0
                )
            ),
            platform = PlatformEntity(
                id = 1,
                name = "2",
                slug = "3",
                symbol = "4",
                tokenAddress = "5"
            )
        )
    )

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `getLatest successful`() {
        every { currencyInfoRemoteDataSource.getLatest() } returns Single.just(currencyInfoEntityList)

        currencyInfoRepository.getLatest()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(currencyInfoEntityList)
    }

    @Test
    fun `getLatest fails`() {
        every { currencyInfoRemoteDataSource.getLatest() } returns Single.error(IOException())

        currencyInfoRepository.getLatest()
            .test()
            .assertNotComplete()
            .assertFailure(IOException::class.java)
    }
}