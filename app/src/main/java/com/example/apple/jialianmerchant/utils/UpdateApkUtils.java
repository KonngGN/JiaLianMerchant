package com.example.apple.jialianmerchant.utils;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者：孔先生 on 2017/2/27 10:54
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class UpdateApkUtils {
    private static DownloadManager downloadManager;
    private static DownloadManager.Request request;

    public static void downloadApk(final Context context, final String url, final String title, final String apk) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        builder.setMessage("更新")
                .setNegativeButton("立即更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request = new DownloadManager.Request(Uri.parse(url));
                        request.setTitle(title)
                                .setMimeType("application/vnd.android.package-archive")
                                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                        .setDestinationInExternalFilesDir( context , Environment.DIRECTORY_DOWNLOADS ,  apk );
                        final long enqueue = downloadManager.enqueue(request);
                        final DownloadManager.Query query = new DownloadManager.Query();
                        final Timer timer = new Timer();
                        TimerTask timerTask = new TimerTask() {
                            @Override
                            public void run() {
                                Cursor cursor = downloadManager.query(query.setFilterById(enqueue));
                                if (cursor != null && cursor.moveToFirst()) {
                                    if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(enqueue);
                                        intent.setDataAndType(uriForDownloadedFile
                                                , "application/vnd.android.package-archive");
                                        context.startActivity(intent);
                                        timer.cancel();
                                    }
                                    String address = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                                    //已经下载的字节数
                                    int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                                    //总需下载的字节数
                                    int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                                    //Notification 标题
                                    String title = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_TITLE));
                                    //描述
                                    String description = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_DESCRIPTION));
                                    //下载对应id
                                    long id1 = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_ID));
                                    //下载文件名称
                                    String filename = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME));
                                    //下载文件的URL链接
                                    String url = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_URI));
                                    Log.e("", "已经下载的字节数: " + bytes_downloaded + " 总需下载的字节数: " + bytes_total + " Notification: " + title + " description: " + description +
                                            " id: " + id1 + " filename: " + filename + " 下载的地址: " + url + " 保存的地址：" + address);
                                } else {
                                    timer.cancel();
                                    Log.e("dd", "else");
                                }
                                Log.e("dd", "cursor=" + cursor.moveToFirst());
                                cursor.close();
                            }
                        };
                        timer.schedule(timerTask, 0, 1000);
                    }

                })
                .setPositiveButton("暂不更新", null);
        builder.show();
    }

    class dd extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                Log.e("!!!!!!!!!!!", "BroadcastReceiver");
            } else if (intent.getAction().equals(DownloadManager.ACTION_NOTIFICATION_CLICKED)) {
                Log.e("!!!!!!!!!!!", "BroadcastReceiver2222");
            }
        }

    }

    private void install(Context context, String path) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }
}
