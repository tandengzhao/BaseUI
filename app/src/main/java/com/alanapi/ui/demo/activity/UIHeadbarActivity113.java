package com.alanapi.ui.demo.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.alanapi.ui.HeadbarActivity;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16下午6:24
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIHeadbarActivity113 extends HeadbarActivity {
  WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    webView = new WebView(this);
    LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    //FrameLayout.LayoutParams ll = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    webView.setLayoutParams(ll);

    setContentView(webView);
    webView.setBackgroundResource(R.color.colorAccent);





    initWebView();

    webView.loadUrl("http://www.baidu.com");



  }

  @Override
  protected void initData() {
    super.initData();
  }

  @Override
  protected void initView() {
    super.initView();
    setTitle("普通HeadbarActivity");

    showToolbarRightOption("右侧1");

    showToolbarLeftOption("关闭");
  }

  @SuppressLint("JavascriptInterface")
  private void initWebView() {
    WebSettings webSettings = webView.getSettings();
    webSettings.setDefaultTextEncodingName("UTF-8");
    webSettings.setAllowFileAccess(true);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setSupportZoom(true);
    webSettings.setUseWideViewPort(true);
    webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    webSettings.setAppCacheEnabled(true);
    webSettings.setDomStorageEnabled(true);
    webSettings.setDatabaseEnabled(true);
    webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    webSettings.setLoadWithOverviewMode(true);
    webView.setWebViewClient(new MyWebViewClient());
  }

  private class MyWebViewClient extends WebViewClient {
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
      super.onPageStarted(view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      if (url.startsWith("tel:")) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
        startActivity(intent);
        return true;
      }
      return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
      return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
      super.onPageFinished(view, url);
    }
  }
}
