package com.example.coinmarketproject.ui.currencyinfo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coinmarketproject.R
import com.example.data.model.CurrencyInfo
import com.squareup.picasso.Picasso

class CurrencyInfoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val nameTextView = view.findViewById<TextView>(R.id.txv_currency_info_name)
    private val slugTextView = view.findViewById<TextView>(R.id.txv_currency_info_slug)
    private val symbolTextView = view.findViewById<TextView>(R.id.txv_currency_info_symbol)
    private val priceTextView = view.findViewById<TextView>(R.id.txv_currency_info_price)
    private val iconImage = view.findViewById<ImageView>(R.id.img_currency_info)

    fun bind(currencyInfo: CurrencyInfo) {
        nameTextView?.text = currencyInfo.name
        slugTextView?.text = currencyInfo.slug
        symbolTextView?.text = currencyInfo.symbol
        priceTextView?.text = "$${currencyInfo.price.toString()}"
        if (!currencyInfo.iconUrl.isNullOrEmpty())
            Picasso.get().load(currencyInfo.iconUrl).into(iconImage)
        else
            iconImage.setBackgroundResource(R.drawable.circle_image)
    }
}