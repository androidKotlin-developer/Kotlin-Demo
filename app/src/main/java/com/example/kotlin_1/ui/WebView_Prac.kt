package com.example.kotlin_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.kotlin_1.R
import kotlinx.android.synthetic.main.activity_web_view_prac.*

class WebView_Prac : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_prac)

        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://www.geeksforgeeks.org/")

        webView.settings.javaScriptEnabled = true

        webView.settings.setSupportZoom(true)

    }

    override fun onBackPressed() {

        if (webView.canGoBack())
            webView.goBack()

        else
            super.onBackPressed()
    }
}