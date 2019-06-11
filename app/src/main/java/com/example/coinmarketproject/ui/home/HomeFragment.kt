package com.example.coinmarketproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.coinmarketproject.R
import com.google.android.material.tabs.TabLayout
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    // @Inject
    lateinit var homePagerAdapter: HomePagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homePagerAdapter = HomePagerAdapter(requireContext(), fragmentManager!!)
        val viewPager = view?.findViewById<ViewPager>(R.id.view_pager_home)
        viewPager?.adapter = homePagerAdapter
        val tabLayout = view?.findViewById<TabLayout>(R.id.tab_layout_home)
        tabLayout?.tabGravity = TabLayout.GRAVITY_FILL
        // tabLayout.setupWithViewPager(viewPager)

        viewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

}
