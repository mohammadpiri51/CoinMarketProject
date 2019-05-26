package com.example.remote.dto

import com.google.gson.annotations.SerializedName

data class ListingDto(
    @SerializedName("data") val items: List<CurrencyInfoDto>,
    @SerializedName("status") val status: StatusDto?
)


