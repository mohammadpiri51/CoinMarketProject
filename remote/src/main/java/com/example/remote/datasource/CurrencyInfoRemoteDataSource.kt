package com.example.remote.datasource

import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.model.CurrencyInfo
import com.example.remote.api.CurrencyInfoService
import com.example.remote.dto.toCurrencyInfoList
import io.reactivex.Single
import javax.inject.Inject

class CurrencyInfoRemoteDataSource @Inject constructor(private val currencyInfoService: CurrencyInfoService) :
    ICurrencyInfoRemoteDataSource {
    override fun getLatest(): Single<List<CurrencyInfo>> {
        return currencyInfoService.getLatest().map { listingDto -> listingDto.toCurrencyInfoList() }
    }
}