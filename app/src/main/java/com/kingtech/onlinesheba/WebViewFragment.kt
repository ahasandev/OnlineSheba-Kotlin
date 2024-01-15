package com.kingtech.onlinesheba

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.kingtech.onlinesheba.databinding.FragmentWebViewBinding
import com.kingtech.onlinesheba.fragments.BaseFragment


class WebViewFragment : BaseFragment<FragmentWebViewBinding>(FragmentWebViewBinding::inflate) {

    var webView: WebView? = null
    var layNonet: LinearLayout? = null
//    var progressBar: LottieAnimationView? = null
    var layRoot: LinearLayout? = null
    var imgBack: ImageView? = null
    var webTitile: TextView? = null
    var animation: Animation? = null
    var USER_AGENT_ =
        "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"
    var USER_AGENT_XX =
        "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"

    var WEBSITE_LINK = ""
    var WEBSITE_TITLE = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = WebView(requireContext())
        webView!!.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        webView!!.fitsSystemWindows = false // your preferences

        webView!!.isVerticalScrollBarEnabled = false // your preferences

        webView!!.setPadding(15, 15, 15, 15) // your preferences

        layRoot!!.addView(webView)

        // Enabling some setting so that browser can work properly

        // Enabling some setting so that browser can work properly
        webView!!.settings.userAgentString = USER_AGENT_
        webView!!.settings.loadsImagesAutomatically = true
        webView!!.settings.javaScriptEnabled = true
        webView!!.settings.allowFileAccess = true
        webView!!.settings.loadWithOverviewMode = true
        webView!!.settings.useWideViewPort = true
        //webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        //webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView!!.webViewClient = HelloWebViewClient()


        //-------------------new setting


        //-------------------new setting
        webView!!.settings.blockNetworkLoads = false
        webView!!.settings.mediaPlaybackRequiresUserGesture = false
        webView!!.settings.domStorageEnabled = true

        webView!!.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        webView!!.settings.setUserAgentString(getString(R.string.app_name))

        webView!!.loadUrl(WEBSITE_LINK)


        if (!isNetworkAvailable(requireContext())) {
            webView!!.visibility = View.GONE
            layNonet!!.visibility = View.VISIBLE
        } else {
            webView!!.visibility = View.VISIBLE
            layNonet!!.visibility = View.GONE
        }

        webTitile!!.text = "" + WEBSITE_TITLE


    }


    private fun isNetworkAvailable(context: Context): Boolean {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo != null
    }

    //================================================= defining custom class (HelloWebViewClient)
    private class HelloWebViewClient : WebViewClient() {
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    //=================================================




}