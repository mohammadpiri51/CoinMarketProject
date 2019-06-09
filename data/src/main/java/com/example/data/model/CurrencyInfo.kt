package com.example.data.model

data class CurrencyInfo(
    val id: Int?,
    val name: String?,
    val platform: Platform?,
    val quote: Quote?,
    val slug: String?,
    val symbol: String?,
    val price: Double?,
    val iconUrl: String?
)