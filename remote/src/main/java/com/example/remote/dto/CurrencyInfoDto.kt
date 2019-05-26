package com.example.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrencyInfoDto(
    @SerializedName("circulating_supply") val circulatingSupply: Double?,
    @SerializedName("cmc_rank") val cmcRank: Int?,
    @SerializedName("date_added") val dateAdded: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("last_updated") val lastUpdated: String?,
    @SerializedName("max_supply") val maxSupply: Any?,
    @SerializedName("name") val name: String?,
    @SerializedName("num_market_pairs") val numMarketPairs: Int?,
    @SerializedName("platform") val platform: PlatformDto?,
    @SerializedName("quote") val quote: QuoteDto,
    @SerializedName("slug") val slug: String?,
    @SerializedName("symbol") val symbol: String?,
    @SerializedName("tags") val tags: List<Any?>?,
    @SerializedName("total_supply") val totalSupply: String?
)





