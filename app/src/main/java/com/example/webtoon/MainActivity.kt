package com.example.webtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.webViewClient = WebViewClient() // 웹뷰 클라이언트 설정
        webView.settings.javaScriptEnabled = true   // 웹뷰 안에서도 자바스크립트 사용 가능하도록 설정

        webView.loadUrl("https://google.com")   //웹뷰에서 띄울 페이지의 URL연결
        onProvideAssistData()
    }
}