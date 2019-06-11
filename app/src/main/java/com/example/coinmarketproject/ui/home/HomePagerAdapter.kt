package com.example.coinmarketproject.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.coinmarketproject.R
import com.example.coinmarketproject.ui.currencyinfo.CurrencyInfoFragment
import com.example.coinmarketproject.ui.exchange.ExchangesFragment
import javax.inject.Inject

class HomePagerAdapter @Inject constructor(
    private val context: Context,
    fragmentManager: FragmentManager
) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CurrencyInfoFragment()
            1 -> ExchangesFragment()
            else -> throw IllegalStateException("Invalid Position")
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.getString(R.string.currencies)
            1 -> context.getString(R.string.exchanges)
            else -> throw IllegalStateException("Invalid Position")
        }
    }
}