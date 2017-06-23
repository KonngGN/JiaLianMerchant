package com.example.apple.jialianmerchant.base;

import android.app.Application;
import android.content.Context;

import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


public class BaseApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initOKhttp();
        initUmeng();
    }

    public static Context getContext() {
        return context;
    }

    /**
     * 初始化OkhttpUtil
     */
    private void initOKhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG", true))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
    /**
     * 友盟统计加密数据初始化
     */
    private void initUmeng() {
        MobclickAgent.enableEncrypt(true);
    }

}
