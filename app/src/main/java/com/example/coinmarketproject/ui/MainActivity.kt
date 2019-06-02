package com.example.coinmarketproject.ui

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.coinmarketproject.R
import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import com.example.coinmarketproject.ui.service.FirstAndLastCoinPriceService

class MainActivity : AppCompatActivity() {

    private var selectedItemId = 0

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if (selectedItemId != R.id.navigation_home) {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.main_content_frame,
                            CurrencyInfoFragment()
                        )
                        .commit()
                    selectedItemId = R.id.navigation_home
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                if (selectedItemId != R.id.navigation_dashboard) {
                    selectedItemId = R.id.navigation_dashboard
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                if (selectedItemId != R.id.navigation_notifications) {
                    selectedItemId = R.id.navigation_notifications
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent(this, FirstAndLastCoinPriceService::class.java)
        startService(intent)
    }

    override fun onStop() {
        super.onStop()
        val intent = Intent(this, FirstAndLastCoinPriceService::class.java)
        stopService(intent)
    }
}
