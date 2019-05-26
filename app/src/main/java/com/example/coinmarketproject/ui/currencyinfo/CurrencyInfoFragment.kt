package com.example.coinmarketproject.ui.currencyinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.coinmarketproject.MainApplication

import com.example.coinmarketproject.R
import javax.inject.Inject

class CurrencyInfoFragment : Fragment() {

    companion object {
        fun newInstance() = CurrencyInfoFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.appComponent.inject(this)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var currencyInfoViewModel: CurrencyInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        currencyInfoViewModel =
            ViewModelProviders.of(this, this.viewModelFactory).get(CurrencyInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
