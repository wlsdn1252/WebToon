package com.example.webtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import com.example.webtoon.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 프래그먼트 어댑터 연결
        viewPager.adapter = ViewPagerAdapter(this)

        // 탭 레이아웃 연결,설정
        TabLayoutMediator(binding.tabLayout, viewPager){tab, position ->
            run{
                // 탭레이아웃 커스텀
                val textView = TextView(this@MainActivity)
                textView.text = "position ${position}"
                textView.gravity = Gravity.CENTER

                tab.customView = textView
                //tab.text = "position ${position}"
            }
        }.attach()

        fun onBackPressed() {
            val currentFragment = supportFragmentManager.fragments[binding.viewPager.currentItem]
            if(currentFragment is WebViewFragment) {
                if(currentFragment.canGoBack()) {
                    currentFragment.goBack()
                } else {
                    super.onBackPressed()
                }
            } else {
                super.onBackPressed()
            }
        }



    }

}