package com.example.remote.datasource

import com.example.remote.api.CurrencyInfoService
import com.example.remote.dto.ListingDto
import com.example.remote.dto.StatusDto
import com.example.remote.dto.toCurrencyInfoEntityList
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class CurrencyInfoRemoteServiceTest {
    private val currencyInfoService = mockk<CurrencyInfoService>()
    private val listingDto = ListingDto(
        items = emptyList(),
        status = StatusDto(0, 0, 0, "", "")
    )
    private val currencyInfoRemoteService = CurrencyInfoRemoteService(currencyInfoService)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `get latest successful`() {
        every { currencyInfoService.getLatest() } returns Single.just(listingDto)

        currencyInfoRemoteService.getLatest()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(listingDto.toCurrencyInfoEntityList())
    }

    @Test
    fun `get latest fails`() {
        every { currencyInfoService.getLatest() } returns Single.error(IOException())

        currencyInfoRemoteService.getLatest()
            .test()
            .assertNotComplete()
            .assertFailure(IOException::class.java)
    }
}