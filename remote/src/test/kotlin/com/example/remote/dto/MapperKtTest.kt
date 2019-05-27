package com.example.remote.dto

import com.example.data.entity.CurrencyInfoEntity
import com.example.data.entity.PlatformEntity
import com.example.data.entity.QuoteEntity
import com.example.data.entity.UsdEntity
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
    fun `ListingDto to CurrencyInfoEntityList`() {
        val currencyInfoEntityList = listOf(currencyInfoDto.toCurrencyInfoEntity())
        assertEquals(currencyInfoEntityList, listingDto.toCurrencyInfoEntityList())
    }

    @Test
    fun `CurrencyInfoDto to CurrencyInfoEntity`() {
        val currencyInfoEntity = CurrencyInfoEntity(
            name = currencyInfoDto.name,
            platform = currencyInfoDto.platform?.toPlatformEntity(),
            symbol = currencyInfoDto.symbol,
            slug = currencyInfoDto.slug,
            quote = currencyInfoDto.quote.toQuoteEntity()
        )

        assertEquals(currencyInfoEntity, currencyInfoDto.toCurrencyInfoEntity())
    }

    @Test
    fun `PlatformDto to PlatformEntity()`() {
        val platformEntity = PlatformEntity(
            id = platformDto.id,
            name = platformDto.name,
            slug = platformDto.slug,
            symbol = platformDto.symbol,
            tokenAddress = platformDto.tokenAddress
        )
        assertEquals(platformEntity, platformDto.toPlatformEntity())
    }

    @Test
    fun `QuoteDto to QuoteEntity`() {
        val quoteEntity = QuoteEntity(
            usd = quoteDto.usd?.toUsdEntity()
        )
    }

    @Test
    fun `UsdDto to UsdEntity`() {
        val usdEntity = UsdEntity(
            lastUpdated = usdDto.lastUpdated,
            volume24h = usdDto.volume24h,
            price = usdDto.price,
            percentChange24h = usdDto.percentChange24h,
            percentChange7d = usdDto.percentChange7d,
            percentChange1h = usdDto.percentChange1h,
            marketCap = usdDto.marketCap
        )
        assertEquals(usdEntity, usdDto.toUsdEntity())
    }
}