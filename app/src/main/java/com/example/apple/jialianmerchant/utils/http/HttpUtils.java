package com.example.apple.jialianmerchant.utils.http;

import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseApp;
import com.example.apple.jialianmerchant.constant.UrlConsts;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;


public class HttpUtils {


    public static void post(String url,Object object, Callback callback) {
        Log.e( "post: ", new Gson().toJson(object));
        OkHttpUtils
                .post()
                .url(UrlConsts.URL_PATH_DATA + url)
                .addParams("postjson", new Gson().toJson(object))
                .build()
                .execute(callback);
    }
    public static void post(String url, Callback callback) {
        OkHttpUtils
                .post()
                .url(UrlConsts.URL_PATH_DATA +url)
                .build()
                .execute(callback);
    }

    public static void downloadBitmap(String url, final ImageView imageView) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.shortToast(e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        if (response != null) {
                            imageView.setImageBitmap(response);
                        } else {
                            imageView.setImageDrawable(ContextCompat.getDrawable(BaseApp.getContext(),R.mipmap.ic_launcher));
                        }
                    }
                });
    }
}
