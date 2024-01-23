package com.kingtech.onlinesheba

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.kingtech.onlinesheba.databinding.FragmentWebViewBinding
import com.kingtech.onlinesheba.fragments.BaseFragment


class WebViewFragment : BaseFragment<FragmentWebViewBinding>(FragmentWebViewBinding::inflate) {


    private var website ="https://www.prothomalo.com/"
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        webView = WebView(requireContext())
//        webView!!.layoutParams =
//            LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT
////            )
//        webView!!.fitsSystemWindows = false // your preferences
//
//        webView!!.isVerticalScrollBarEnabled = false // your preferences

        binding.webView.setPadding(15, 15, 15, 15) // your preferences

//        layRoot!!.addView(webView)

        // Enabling some setting so that browser can work properly

        // Enabling some setting so that browser can work properly
//        webView!!.settings.userAgentString = USER_AGENT_
        binding.webView.settings.loadsImagesAutomatically = true
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.allowFileAccess = true
//        webView!!.settings.loadWithOverviewMode = true
//        webView!!.settings.useWideViewPort = true
        //webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        //webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        binding.webView.webViewClient = HelloWebViewClient()


        //-------------------new setting


        //-------------------new setting
//        webView!!.settings.blockNetworkLoads = false
//        webView!!.settings.mediaPlaybackRequiresUserGesture = false
//        webView!!.settings.domStorageEnabled = true

        binding.webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        binding.webView.settings.userAgentString = getString(R.string.app_name)

        binding.webView.loadUrl(website)


//        if (!isNetworkAvailable(requireContext())) {
//            webView!!.visibility = View.GONE
//            layNonet!!.visibility = View.VISIBLE
//        } else {
//            webView!!.visibility = View.VISIBLE
////            layNonet!!.visibility = View.GONE
//        }



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