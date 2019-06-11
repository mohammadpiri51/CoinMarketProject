package com.example.local.datasource

import android.content.SharedPreferences
import com.example.data.model.CurrencyInfo
import com.example.data.model.Platform
import com.example.data.model.Quote
import com.example.data.model.Usd
import kotlin.random.Random

fun SharedPreferences.clear() {
    val edit = edit()
    all.forEach { (k, _) ->
        edit.remove(k)
    }
    edit.commit()
}

fun randomCurrencyInfo(): CurrencyInfo = CurrencyInfo(
    id = Random.nextInt(),
    name = Random.nextInt().toString(),
    price = Random.nextDouble(),
    slug = Random.nextInt().toString(),
    symbol = Random.nextInt().toString(),
    iconUrl = Random.nextInt().toString(),
    platform = Platform(
        id = Random.nextInt(),
        name = Random.nextInt().toString(),
        symbol = Random.nextInt().toString(),
        slug = Random.nextInt().toString(),
        tokenAddress = Random.nextInt().toString()
    ),
    quote = Quote(
        usd = Usd(
            lastUpdated = Random.nextInt().toString(),
            price = Random.nextDouble(),
            volume24h = Random.nextDouble(),
            percentChange24h = Random.nextDouble(),
            percentChange7d = Random.nextDouble(),
            percentChange1h = Random.nextDouble(),
            marketCap = Random.nextDouble()
        )
    )
)