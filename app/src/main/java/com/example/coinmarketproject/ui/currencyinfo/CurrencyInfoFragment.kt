package com.example.coinmarketproject.ui.currencyinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coinmarketproject.MainApplication

import com.example.coinmarketproject.R
import com.example.data.entity.CurrencyInfoEntity
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
        return inflater.inflate(R.layout.fragment_currency_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currencyInfoViewModel =
            ViewModelProviders.of(this, this.viewModelFactory).get(CurrencyInfoViewModel::class.java)
        currencyInfoViewModel.getLatest()
        currencyInfoViewModel.getLatestResult.observe(this, Observer(this::onCurrencyInfoListReady))

    }

    private fun onCurrencyInfoListReady(currencyInfoEntityList: List<CurrencyInfoEntity>) {
        val recyclerView=view?.findViewById<RecyclerView>(R.id.rv_currency_info)
        recyclerView?.layoutManager=LinearLayoutManager(requireContext())
        val currencyInfoAdapter=CurrencyInfoAdapter(currencyInfoEntityList)
        recyclerView?.adapter=currencyInfoAdapter
    }

}
