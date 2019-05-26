package com.example.coinmarketproject.ui.currencyinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.entity.CurrencyInfoEntity
import com.example.data.repository.CurrencyInfoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrencyInfoViewModel @Inject constructor(private val currencyInfoRepository: CurrencyInfoRepository) :
    ViewModel() {
    private var _getLatestResult = MutableLiveData<List<CurrencyInfoEntity>>()
    val getLatestResult: LiveData<List<CurrencyInfoEntity>> = _getLatestResult

    fun getLatest() {
        currencyInfoRepository.getLatest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ currencyInfoEntityList ->
                _getLatestResult.value = currencyInfoEntityList
            }, {
                it.printStackTrace()
            })
    }
}
