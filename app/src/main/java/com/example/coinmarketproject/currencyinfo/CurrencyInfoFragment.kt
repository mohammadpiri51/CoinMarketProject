package com.example.coinmarketproject.currencyinfo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.coinmarketproject.R

class CurrencyInfoFragment : Fragment() {

    companion object {
        fun newInstance() = CurrencyInfoFragment()
    }

    private lateinit var viewModel: CurrencyInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrencyInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
