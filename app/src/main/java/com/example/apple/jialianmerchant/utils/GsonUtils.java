package com.example.apple.jialianmerchant.utils;

import com.google.gson.Gson;



public class GsonUtils {
    public static <T> T parse(String json,Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
}
