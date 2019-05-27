package com.example.remote.dto

import com.example.data.entity.CurrencyInfoEntity
import com.example.data.entity.PlatformEntity
import com.example.data.entity.QuoteEntity
import com.example.data.entity.UsdEntity

fun ListingDto.toCurrencyInfoEntityList():List<CurrencyInfoEntity>{
    return this.items.map { currencyInfoDto -> currencyInfoDto.toCurrencyInfoEntity() }
}

fun CurrencyInfoDto.toCurrencyInfoEntity(): CurrencyInfoEntity {
    return CurrencyInfoEntity(
        name = this.name,
        symbol = this.symbol,
        slug = this.slug,
        platform = this.platform?.toPlatformEntity(),
        quote = this.quote?.toQuoteEntity()
    )
}

fun PlatformDto.toPlatformEntity(): PlatformEntity {
    return PlatformEntity(
        id = this.id,
        name = this.name,
        slug = this.slug,
        symbol = this.symbol,
        tokenAddress = this.tokenAddress
    )
}

fun QuoteDto.toQuoteEntity(): QuoteEntity {
    return QuoteEntity(
        usd = this.usd?.toUsdEntity()
    )
}

fun UsdDto.toUsdEntity(): UsdEntity {
    return UsdEntity(
        lastUpdated = this.lastUpdated,
        marketCap = this.marketCap,
        percentChange1h = this.percentChange1h,
        percentChange7d = this.percentChange7d,
        percentChange24h = this.percentChange24h,
        price = this.price,
        volume24h = this.volume24h
    )
}