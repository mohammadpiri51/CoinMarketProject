package com.example.coinmarketproject.ui.currencyinfo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coinmarketproject.R
import com.example.data.model.CurrencyInfo

class CurrencyInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nameTextView = view.findViewById<TextView>(R.id.txv_currency_info_name)
    private val slugTextView = view.findViewById<TextView>(R.id.txv_currency_info_slug)
    private val symbolTextView = view.findViewById<TextView>(R.id.txv_currency_info_symbol)

    fun bind(currencyInfo: CurrencyInfo) {
        nameTextView?.text = currencyInfo.name
        slugTextView?.text = currencyInfo.slug
        symbolTextView?.text = currencyInfo.symbol
    }
}