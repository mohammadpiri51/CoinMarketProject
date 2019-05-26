package com.example.coinmarketproject.ui.currencyinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coinmarketproject.R
import com.example.data.entity.CurrencyInfoEntity

class CurrencyInfoAdapter(private val items: List<CurrencyInfoEntity>) :
    RecyclerView.Adapter<CurrencyInfoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency_info_item, parent, false)
        return CurrencyInfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: CurrencyInfoViewHolder, position: Int) {
        holder.bind(items[position])
    }

}