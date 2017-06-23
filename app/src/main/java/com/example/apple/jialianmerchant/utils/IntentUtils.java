package com.example.apple.jialianmerchant.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;


public class IntentUtils {

    public static <T> void toActivity(Context context, Class<T> tClass) {
        Intent intent = new Intent(context, tClass);
        context.startActivity(intent);
    }

    public static <T> void toActivity(Context context, Class<T> tClass, String key, String values) {
        Intent intent = new Intent(context, tClass);
        intent.putExtra(key, values);
        context.startActivity(intent);
    }

    public static <T> void toActivity(Context context, Class<T> tClass, String key, int values) {
        Intent intent = new Intent(context, tClass);
        intent.putExtra(key, values);
        context.startActivity(intent);
    }

    public static <T> void toActivity(Context context, Class<T> tClass, String key, String values, String key2, String values2) {
        Intent intent = new Intent(context, tClass);
        intent.putExtra(key, values);
        intent.putExtra(key2, values2);
        context.startActivity(intent);
    }

    public static <T> void toActivity(Context context, Class<T> tClass, String key, String values, String key2, boolean values2) {
        Intent intent = new Intent(context, tClass);
        intent.putExtra(key, values);
        intent.putExtra(key2, values2);
        context.startActivity(intent);
    }

    public static <T> void toActivity(Context context, Class<T> tClass, String key, String values, String key2, double values2,String key3, boolean values3) {
        Intent intent = new Intent(context, tClass);
        intent.putExtra(key, values);
        intent.putExtra(key2, values2);
        intent.putExtra(key3, values3);
        context.startActivity(intent);
    }

    /**
     * 打电话
     */
    public static void phoneDialogUtils(Context context, String phone) {
        if (phone != null && !phone.equals("")) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phone.trim()));
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "联系客服失败", Toast.LENGTH_SHORT).show();
        }
    }
}
