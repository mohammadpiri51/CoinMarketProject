package com.example.data.entity

data class CurrencyInfoEntity(
    val name: String?,
    val platform: PlatformEntity?,
    val quote: QuoteEntity?,
    val slug: String?,
    val symbol: String?
)