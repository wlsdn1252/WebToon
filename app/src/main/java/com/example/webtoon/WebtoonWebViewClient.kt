package com.example.webtoon

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonWebViewClient(
    private val progressBar:ProgressBar,
    private val savaData: (String) -> Unit): WebViewClient() {

    // sharedPreferences 저장 구문
    // shouldOverrideUrlLoading = Url을 로드할 때 실행되는 구문
    // request를 받아서 검사하고 comic.naver.com/webtoon/detail을 포함하고 있으면
    // savaData 함수를 호출하여 WebViewFragment클래스 파일의 webViewClient에서 호출된다
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        //https://comic.naver.com/webtoon/detail?titleId=783053&no=79 들어오는 주소
        if(request != null && request.url.toString().contains("comic.naver.com/webtoon/detail")){
            savaData(request.url.toString())
        }
        
        return super.shouldOverrideUrlLoading(view, request)
    }

    // 로딩이 끝나면 프로그래스 바를 숨긴다.
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        progressBar.visibility = View.VISIBLE
    }
}