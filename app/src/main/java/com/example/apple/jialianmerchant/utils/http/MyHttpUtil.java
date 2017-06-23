package com.example.apple.jialianmerchant.utils.http;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import com.example.apple.jialianmerchant.bean.request.UserRequest;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;

import okhttp3.Call;
import okhttp3.MediaType;

import static com.zhy.http.okhttp.log.LoggerInterceptor.TAG;


public class MyHttpUtil {



    private void get() {
        String url = "http://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                             @Override
                             public void onError(Call call, Exception e, int id) {

                             }

                             @Override
                             public void onResponse(String response, int id) {

                             }
                         }
                );
    }

    //        POST请求
    private void post(String url, Callback callback) {

        OkHttpUtils
                .post()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(callback);
    }

    //Post JSON
    private void PostJSON(String url, Callback callback) {

        OkHttpUtils
                .postString()
                .url(url)
                .content(new Gson().toJson(new UserRequest("zhy", "123")))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(callback);
    }

    private void postFile(String url, File file, Callback callback) {
        OkHttpUtils
                .postFile()
                .url(url)
                .file(file)
                .build()
//                .execute(new MyStringCallback());
                .execute(callback);
    }

    /**
     * 支持单个多个文件，addFile的第一个参数为文件的key，即类别表单中<input type="file" name="mFile"/>的name属性。
     */
    private void postJsonAndFile(String url, File file, File file2, Callback callback) {
        OkHttpUtils.post()//
                .addFile("mFile", "messenger_01.png", file)//
                .addFile("mFile", "test1.txt", file2)//
                .url(url)
//                .params(params)//
//                .headers(headers)//
                .build()//
                .execute(callback);
    }

    public static void dowloadFile(String url, final File file) {
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "gson-2.2.1.jar") {
                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
//                        mProgressBar.setProgress((int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                    }
                });
    }

    private void downloadBitmap(String url) {
        OkHttpUtils
                .get()//
                .url(url)//
                .build()//
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
//                        mTv.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
//                        mImageView.setImageBitmap(response);
                    }
                });
    }
}
