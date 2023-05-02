package com.example.webtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.webtoon.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼1을 누르면 WebViewFragment 실행
        button1.setOnClickListener {
            //  supportFragmentManager : 액티비티 내부기능, 액티비티 내의 프래그먼트를 관리함
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.FragmentContainer, WebViewFragment())
                commit()
            }
        }
        //버튼2을 누르면 WebViewFragment 실행
        button2.setOnClickListener {
            //  supportFragmentManager : 액티비티 내부기능, 액티비티 내의 프래그먼트를 관리함
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.FragmentContainer, BFragment())
                commit()
            }
        }


    }

}