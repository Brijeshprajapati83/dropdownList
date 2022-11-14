package com.example.demowebsankul

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                VideoFragment()
            }
            1 -> {
                MaterialFragment()
            }
            2 -> {
                TestFragment()
            }
            else -> VideoFragment()
        }
    }
}