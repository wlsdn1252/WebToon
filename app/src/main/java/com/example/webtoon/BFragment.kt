package com.example.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webtoon.databinding.FragmentSecoundBinding
import com.example.webtoon.databinding.FragmentWebviewBinding

class BFragment:Fragment() {

    lateinit var binding: FragmentSecoundBinding

    // 뷰가 처음 만들어질 때 뿌려질 화면 정의?
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecoundBinding.inflate(inflater)
        // root를 반환 시 fragment_webview.xml파일의 최 상위 레이아웃(콘스트레인트 레이아웃)이 리턴된다
        return binding.root
    }
}