package com.example.kotlin_1.tablayout


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_1.tablayout.fragment.HomeFragment
import com.example.kotlin_1.tablayout.fragment.MovieFragent
import com.example.kotlin_1.tablayout.fragment.SportFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0->{
                HomeFragment()
            }
            1->{
                MovieFragent()
            }
            2->{
                SportFragment()
            }
            else->{
                Fragment()
            }

        }
    }
}