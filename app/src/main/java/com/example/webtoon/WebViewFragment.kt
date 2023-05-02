package com.example.webtoon

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.webtoon.databinding.FragmentWebviewBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_webview.*

class WebViewFragment(private val position : Int):Fragment() {

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

        // shouldOverrideUrlLoading에서 저장이 될 떄 뭐뭐뭐 된다.....ㅋ
        webView.webViewClient = WebtoonWebViewClient(binding.prograssBar) { url ->
            activity?.getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE)?.edit {
                putString("tab$position", url)
            }
        } // 웹뷰 클라이언트 설정
        webView.settings.javaScriptEnabled = true   // 웹뷰 안에서도 자바스크립트 사용 가능하도록 설정
        webView.loadUrl("https://comic.naver.com/webtoon/detail?titleId=783053&no=79")   //웹뷰에서 띄울 페이지의 URL연결

        // 마지막 시점으로 돌아가기 버튼 클릭시
        backToLastButton.setOnClickListener {
            val sharedPreferences = activity?.getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE)
            val url = sharedPreferences?.getString("tab$position","")
            if(url.isNullOrEmpty()){
                Toast.makeText(context, "마지막 저장 시점이 없습니다.", Toast.LENGTH_SHORT).show()
            }else{
                webView.loadUrl(url)

            }
        }
    }



    fun canGoBack(): Boolean{
        return binding.webView.canGoBack()
    }

    fun goBack() {
        binding.webView.goBack()
    }

}