package com.example.apple.jialianmerchant.utils;

import android.widget.Toast;

import com.example.apple.jialianmerchant.base.BaseApp;

/**
 * Toast工具，对两次Toast间隔做判断，避免Toast不刷新
 */
public class ToastUtils {


    private static String oldMsg;
    private static Toast toast   = null;
    private static long oneTime=0;
    private static long twoTime=0;

    public static void shortToast(String s){
        if(toast==null){
            toast = Toast.makeText(BaseApp.getContext(), s, Toast.LENGTH_SHORT);
            toast.show();
            oneTime= System.currentTimeMillis();
        }else{
            twoTime= System.currentTimeMillis();
            if(s.equals(oldMsg)){
                if(twoTime-oneTime> Toast.LENGTH_SHORT){
                    toast.show();
                }
            }else{
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime=twoTime;
    }

}
