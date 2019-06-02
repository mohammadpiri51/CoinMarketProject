package com.example.coinmarketproject.ui.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.coinmarketproject.MainApplication
import com.example.coinmarketproject.utils.NotificationHelper
import com.example.data.model.CurrencyInfo
import com.example.data.repository.CurrencyInfoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FirstAndLastCoinPriceService : Service() {

    @Inject
    lateinit var currencyInfoRepository: CurrencyInfoRepository

    var firstCoinPrice: CurrencyInfo? = null
    var lastCoinPrice: CurrencyInfo? = null


    override fun onCreate() {
        super.onCreate()
        MainApplication.appComponent.inject(this)
        println("serviceOnCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("serviceOnStartCommand")


        currencyInfoRepository.getLatest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                firstCoinPrice = it.maxWith(Comparator { a, b -> (a.price!!).compareTo(b.price!!) })
                lastCoinPrice = it.minWith(Comparator { a, b -> (a.price!!).compareTo(b.price!!) })

                val notificationHelper = NotificationHelper(baseContext)
                val notification = notificationHelper.notificationBuilder(
                    "highest and lowest price of digital coins",
                    "",
                    firstCoinPrice?.name + " : " + firstCoinPrice?.price + "$" + " - " +
                            lastCoinPrice?.name + " : " + lastCoinPrice?.price + "$"
                )

                startForeground(1, notification.build())

            }, {
                it.printStackTrace()
            })

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("serviceOnDestroy")

    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}