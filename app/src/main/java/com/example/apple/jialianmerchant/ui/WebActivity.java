package com.example.apple.jialianmerchant.ui;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.constant.KeyConsts;

import butterknife.BindView;
import butterknife.OnClick;

public class WebActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    public int initLayout() {
        return R.layout.activity_web;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initView() {
        tvTitle.setText("消息详情");
        String url = getIntent().getStringExtra(KeyConsts.WEB_URL);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
                if (progressBar.getProgress() == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }


    @OnClick(R.id.iv_back)
    public void onClick() {
        this.finish();
    }
}
