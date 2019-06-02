package com.example.local.mapper

import com.example.data.model.CurrencyInfo
import com.example.local.entity.CurrencyInfoEntity

fun CurrencyInfoEntity.toCurrencyInfo(): CurrencyInfo {
    return CurrencyInfo(
        name = this.name,
        symbol = this.symbol,
        slug = this.slug,
        platform = null,
        quote = null,
        price = this.price
    )
}

fun List<CurrencyInfoEntity>.toCurrencyInfoList(): List<CurrencyInfo> {
    return this.map { it.toCurrencyInfo() }
}

fun CurrencyInfo.toCurrencyInfoEntity(): CurrencyInfoEntity {
    return CurrencyInfoEntity(
        id = null,
        name = this.name,
        slug = this.slug,
        symbol = this.symbol,
        price = this.price
    )
}

fun List<CurrencyInfo>.toCurrencyInfoEntityList(): List<CurrencyInfoEntity> {
    return this.map { it.toCurrencyInfoEntity() }
}