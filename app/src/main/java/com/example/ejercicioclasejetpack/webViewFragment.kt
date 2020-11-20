package com.example.ejercicioclasejetpack

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_web_view.*


class webViewFragment : Fragment() {
    private val BASE_URL="https://google.com/"
    private val SEARCH_PATH="/search?q="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                if(webView.canGoBack()){
                    webView.goBack()
                }else{
                    val directions=webViewFragmentDirections.actionWebViewFragmentToMenuFragment()
                    findNavController().navigate(directions)

                }

            }
        })
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sw_Refresh.setOnRefreshListener {
            webView.reload()
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    var url=""
                    if(URLUtil.isValidUrl(it)){
                        url=it
                    } else{
                        url="$BASE_URL$SEARCH_PATH$it"
                    }
                    webView.loadUrl(url)
                }
                return false
            }
        })
        webView.webChromeClient=object : WebChromeClient(){


        }
        webView.webViewClient=object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                searchView.setQuery(url,false)
                sw_Refresh.isRefreshing=true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                sw_Refresh.isRefreshing=false
            }
        }
        val configuracionWeb = webView.settings
        configuracionWeb.javaScriptEnabled=true
        webView.loadUrl(BASE_URL)

    }






}


