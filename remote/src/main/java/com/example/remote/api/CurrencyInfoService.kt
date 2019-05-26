package com.example.remote.api

import com.example.remote.dto.ListingDto
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface CurrencyInfoService {
    @Headers("X-CMC_PRO_API_KEY:c18ecae8-7ac7-484d-8e4f-d4f62654e318")
    @GET("/v1/cryptocurrency/listings/latest")
    fun getLatest(): Single<ListingDto>
}
