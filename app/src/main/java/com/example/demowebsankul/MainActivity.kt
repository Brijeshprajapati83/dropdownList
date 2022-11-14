package com.example.demowebsankul

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import androidx.lifecycle.ViewModelProvider
import com.example.demowebsankul.data.UserViewModel
import com.example.demowebsankul.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var mUserViewModel: UserViewModel
//    private lateinit var database: data.VehicalDatabase

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val tabList = arrayOf("DropDown", "EditText", "RadioButton")
        val iconList = arrayOf(R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground)

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter



        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabList[position]
            tab.setIcon(iconList[position])
        }.attach()

        // Stop viewPager Slider...
//        binding.viewPager.isUserInputEnabled = false



            binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position

//                val fragmentManager: FragmentManager = supportFragmentManager
//                fragmentManager.popBackStack(BACK_STACK_ROOT_TAG,
//                    FragmentManager.POP_BACK_STACK_INCLUSIVE)

                if (tab.position == 0) {
                    binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_launcher_foreground)


                    // Stop The Tooltip...
                    for (i in 0 until binding.tabLayout.tabCount) {
                        binding.tabLayout.getTabAt(i)?.view?.let { tabView ->
                            TooltipCompat.setTooltipText(tabView, null)
                        }
                    }

                }
                if (tab.position == 1) {
                    binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_launcher_foreground)

                    binding.tabLayout.scrollX = binding.tabLayout.width;
                    binding.tabLayout.getTabAt(1)?.select();

                    for (i in 0 until binding.tabLayout.tabCount) {
                        binding.tabLayout.getTabAt(i)?.view?.let { tabView ->
                            TooltipCompat.setTooltipText(tabView, null)
                        }
                    }
                }
                if (tab.position == 2) {
                    binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_launcher_foreground)

                    for (i in 0 until binding.tabLayout.tabCount) {
                        binding.tabLayout.getTabAt(i)?.view?.let { tabView ->
                            TooltipCompat.setTooltipText(tabView, null)
                        }
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_launcher_foreground)
                binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_launcher_foreground)
                binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_launcher_foreground)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }
}