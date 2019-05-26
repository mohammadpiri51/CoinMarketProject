package com.example.remote.datasource

import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.entity.CurrencyInfoEntity
import com.example.remote.api.CurrencyInfoService
import com.example.remote.dto.toCurrencyInfoEntityList
import io.reactivex.Single
import javax.inject.Inject

class CurrencyInfoRemoteService @Inject constructor(private val currencyInfoService: CurrencyInfoService) :
    ICurrencyInfoRemoteDataSource {
    override fun getLatest(): Single<List<CurrencyInfoEntity>> {
        return currencyInfoService.getLatest().map { listingDto -> listingDto.toCurrencyInfoEntityList() }
    }
}