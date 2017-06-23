package com.example.apple.jialianmerchant.utils.http;

import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;


public  abstract class MyStringCallback extends Callback<String> {
    @Override
    public String parseNetworkResponse(Response response, int id) throws Exception {
        return response.body().toString();
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        ToastUtils.shortToast(e.getMessage());
    }

}
