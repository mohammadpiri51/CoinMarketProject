package com.example.remote.dto

import com.example.data.model.CurrencyInfo
import com.example.data.model.Platform
import com.example.data.model.Quote
import com.example.data.model.Usd

fun ListingDto.toCurrencyInfoList(): List<CurrencyInfo> {
    return this.items.map { currencyInfoDto -> currencyInfoDto.toCurrencyInfo() }
}

fun CurrencyInfoDto.toCurrencyInfo(): CurrencyInfo {
    return CurrencyInfo(
        name = this.name,
        symbol = this.symbol,
        slug = this.slug,
        platform = this.platform?.toPlatform(),
        quote = this.quote?.toQuote()
    )
}

fun PlatformDto.toPlatform(): Platform {
    return Platform(
        id = this.id,
        name = this.name,
        slug = this.slug,
        symbol = this.symbol,
        tokenAddress = this.tokenAddress
    )
}

fun QuoteDto.toQuote(): Quote {
    return Quote(
        usd = this.usd?.toUsd()
    )
}

fun UsdDto.toUsd(): Usd {
    return Usd(
        lastUpdated = this.lastUpdated,
        marketCap = this.marketCap,
        percentChange1h = this.percentChange1h,
        percentChange7d = this.percentChange7d,
        percentChange24h = this.percentChange24h,
        price = this.price,
        volume24h = this.volume24h
    )
}