package com.example.apple.jialianmerchant.constant;

import com.example.apple.jialianmerchant.utils.SharedPreferencesUtils;


public class MessageConsts {

    public static String getSooID() {
        return SharedPreferencesUtils.getLoginMessage().getString(KeyConsts.SOOID, "");
    }

    public static String getSign() {
        return SharedPreferencesUtils.getLoginMessage().getString(KeyConsts.SOOTIMESIGN, "");
    }
}
