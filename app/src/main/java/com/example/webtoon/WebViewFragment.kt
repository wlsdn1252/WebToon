package com.example.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.webtoon.databinding.FragmentWebviewBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_webview.*

class WebViewFragment:Fragment() {

    lateinit var binding: FragmentWebviewBinding

    // 뷰가 처음 만들어질 때 뿌려질 화면 정의?
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebviewBinding.inflate(inflater)
        // root를 반환 시 fragment_webview.xml파일의 최 상위 레이아웃(콘스트레인트 레이아웃)이 리턴된다
        return binding.root
    }

    // view가 만들어진 후
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView

        webView.webViewClient = WebViewClient() // 웹뷰 클라이언트 설정
        webView.settings.javaScriptEnabled = true   // 웹뷰 안에서도 자바스크립트 사용 가능하도록 설정
        webView.loadUrl("https://google.com")   //웹뷰에서 띄울 페이지의 URL연결
    }

}