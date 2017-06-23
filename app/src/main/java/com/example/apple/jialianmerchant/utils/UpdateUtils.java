package com.example.apple.jialianmerchant.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.apple.jialianmerchant.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;
import okhttp3.Request;

import static com.zhy.http.okhttp.log.LoggerInterceptor.TAG;


public class UpdateUtils {

    private static NotificationCompat.Builder builder;
    public static int i;

    public static void post(final Context context) {

        OkHttpUtils//
                .get()//
                .url("http://ojapfzebk.bkt.clouddn.com/JiaLianV1.6.3.apk")//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "myapk.apk") {

                    private NotificationManager notificationManager;

                    @Override
                    public void onAfter(int id) {
                        super.onAfter(id);
                        Log.e("", "onAfter: ");
                    }

                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                        builder = new NotificationCompat.Builder(context);
                        builder.setSmallIcon(R.mipmap.newprompt_icon)
                                .setContentTitle("下载中...")
                                .setContentInfo("0%");
                        notificationManager.notify(1, builder.build());
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
//                        BigDecimal b = new BigDecimal((float) progress / (float) total);
//                        float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                        int v = (int) (progress * 100);
                        if (v > i * 10) {//避免下载刷新过快卡顿
                            i++;
                            builder.setProgress(100, v, false);
                            builder.setContentInfo(v + "%");
                            notificationManager.notify(1, builder.build());
                        } else if (v == 100) {
                            builder.setProgress(100, v, false);
                            builder.setContentInfo(v + "%");
                            notificationManager.notify(1, builder.build());
                        }
                        Log.i("JAVA", "current：" + progress + "，total：" + total );
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        notificationManager.cancel(1);
                        Log.e(TAG, "onResponse :" + response.getAbsolutePath());
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setDataAndType(Uri.fromFile(response), "application/vnd.android.package-archive");
                        context.startActivity(intent);
                        Process.killProcess(Process.myPid());
                    }
                });
    }
}
