package com.example.apple.jialianmerchant.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apple.jialianmerchant.base.BaseApp;
import com.example.apple.jialianmerchant.constant.KeyConsts;


public class SharedPreferencesUtils {

    /**
     * 保存登录信息
     */
    public static SharedPreferences getLoginMessage() {
        return BaseApp.getContext().getSharedPreferences(KeyConsts.LOGIN, Context.MODE_PRIVATE);
    }

    /**
     * 保存登录信息
     */
    public static void saveLoginMessage(String sooID,String sooTimeSign,boolean isLogin) {
        SharedPreferencesUtils.getLoginMessage().edit().putString(KeyConsts.SOOID,sooID).apply();
        SharedPreferencesUtils.getLoginMessage().edit().putString(KeyConsts.SOOTIMESIGN,sooTimeSign).apply();
        SharedPreferencesUtils.getLoginMessage().edit().putBoolean(KeyConsts.ALREADY_LOGGED,isLogin).apply();
    }

    /**
     * 保存登录信息
     */
    public static void saveLoginMessage(String username,String password,String sooID,String sooTimeSign,boolean isLogin) {
        SharedPreferencesUtils.getLoginMessage().edit().putString(KeyConsts.USER_NAME,username).apply();
        SharedPreferencesUtils.getLoginMessage().edit().putString(KeyConsts.PASS_WORD,password).apply();
        SharedPreferencesUtils.getLoginMessage().edit().putString(KeyConsts.SOOID,sooID).apply();
        SharedPreferencesUtils.getLoginMessage().edit().putString(KeyConsts.SOOTIMESIGN,sooTimeSign).apply();
        SharedPreferencesUtils.getLoginMessage().edit().putBoolean(KeyConsts.ALREADY_LOGGED,isLogin).apply();
    }

}
