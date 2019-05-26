package com.example.data.datasource

import com.example.data.entity.CurrencyInfoEntity
import io.reactivex.Single

interface ICurrencyInfoRemoteDataSource {
    fun getLatest(): Single<List<CurrencyInfoEntity>>
}