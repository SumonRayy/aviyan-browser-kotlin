package com.sumonrayy.aviyan

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_browser.settings.javaScriptEnabled = true
        web_browser.canGoBack()
        web_browser.webViewClient = WebClient(this)
        search_btn.setOnClickListener{
            val URL = url_txt.text.toString()
            web_browser.loadUrl(URL)
        }

        back_btn.setOnClickListener {
            web_browser.goBack()
        }
        web_browser.loadUrl("https://www.google.com/")


    }

    class WebClient internal constructor(private val activity: Activity):WebViewClient(){
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }
    }
}