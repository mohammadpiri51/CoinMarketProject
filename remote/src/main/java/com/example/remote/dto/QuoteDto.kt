package com.example.remote.dto

import com.google.gson.annotations.SerializedName

data class QuoteDto(
    @SerializedName("USD") val usd: UsdDto?
)