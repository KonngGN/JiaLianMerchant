package com.example.apple.jialianmerchant.utils;

import android.app.ProgressDialog;
import android.content.Context;


public class ProgressDialogUtils {

    private static ProgressDialog progressDialog;

    public static ProgressDialog getLoadingDialog(Context context, String msg) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static ProgressDialog getLoadingDataDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("获取数据中");
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
