package com.example.remote.dto

import com.example.data.model.CurrencyInfo
import com.example.data.model.Platform
import com.example.data.model.Quote
import com.example.data.model.Usd
import com.example.remote.mapper.*
import org.junit.Test

import org.junit.Assert.*
import kotlin.random.Random

class MapperKtTest {

    private val platformDto = PlatformDto(
        id = Random.nextInt(),
        name = Random.nextInt().toString(),
        slug = Random.nextInt().toString(),
        symbol = Random.nextInt().toString(),
        tokenAddress = Random.nextInt().toString()
    )

    private val usdDto = UsdDto(
        lastUpdated = Random.nextInt().toString(),
        marketCap = Random.nextDouble(),
        percentChange1h = Random.nextDouble(),
        percentChange24h = Random.nextDouble(),
        percentChange7d = Random.nextDouble(),
        price = Random.nextDouble(),
        volume24h = Random.nextDouble()
    )

    private val quoteDto = QuoteDto(
        usd = usdDto
    )

    private val currencyInfoDto = CurrencyInfoDto(
        circulatingSupply = Random.nextDouble(),
        cmcRank = Random.nextInt(),
        dateAdded = Random.nextInt().toString(),
        id = Random.nextInt(),
        lastUpdated = Random.nextInt().toString(),
        maxSupply = Random.nextInt(),
        name = Random.nextInt().toString(),
        numMarketPairs = Random.nextInt(),
        platform = platformDto,
        quote = quoteDto,
        slug = Random.nextInt().toString(),
        symbol = Random.nextInt().toString(),
        tags = listOf(Random.nextInt().toString(), Random.nextInt().toString()),
        totalSupply = Random.nextInt().toString()
    )

    private val statusDto = StatusDto(
        creditCount = Random.nextInt(),
        elapsed = Random.nextInt(),
        errorCode = Random.nextInt(),
        errorMessage = Random.nextInt().toString(),
        timestamp = Random.nextInt().toString()
    )

    private val listingDto = ListingDto(
        listOf(currencyInfoDto),
        statusDto
    )

    @Test
    fun `ListingDto to CurrencyInfoList`() {
        val currencyInfoList = listOf(currencyInfoDto.toCurrencyInfo())
        assertEquals(currencyInfoList, listingDto.toCurrencyInfoList())
    }

    @Test
    fun `CurrencyInfoDto to CurrencyInfo`() {
        val currencyInfo = CurrencyInfo(
            name = currencyInfoDto.name,
            platform = currencyInfoDto.platform?.toPlatform(),
            symbol = currencyInfoDto.symbol,
            slug = currencyInfoDto.slug,
            quote = currencyInfoDto.quote.toQuote()
        )

        assertEquals(currencyInfo, currencyInfoDto.toCurrencyInfo())
    }

    @Test
    fun `PlatformDto to Platform()`() {
        val platform = Platform(
            id = platformDto.id,
            name = platformDto.name,
            slug = platformDto.slug,
            symbol = platformDto.symbol,
            tokenAddress = platformDto.tokenAddress
        )
        assertEquals(platform, platformDto.toPlatform())
    }

    @Test
    fun `QuoteDto to Quote`() {
        val quote = Quote(
            usd = quoteDto.usd?.toUsd()
        )
    }

    @Test
    fun `UsdDto to Usd`() {
        val usd = Usd(
            lastUpdated = usdDto.lastUpdated,
            volume24h = usdDto.volume24h,
            price = usdDto.price,
            percentChange24h = usdDto.percentChange24h,
            percentChange7d = usdDto.percentChange7d,
            percentChange1h = usdDto.percentChange1h,
            marketCap = usdDto.marketCap
        )
        assertEquals(usd, usdDto.toUsd())
    }
}