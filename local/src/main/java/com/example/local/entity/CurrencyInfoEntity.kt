package com.example.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CurrencyInfo")
data class CurrencyInfoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "slug")
    val slug: String?,

    @ColumnInfo(name = "symbol")
    val symbol: String?,

    @ColumnInfo(name = "price")
    val price: Double?
)