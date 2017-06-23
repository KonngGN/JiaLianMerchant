package com.example.apple.jialianmerchant.utils.http;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.apple.jialianmerchant.R;

/**
 * 作者：孔先生 on 2017/3/13 14:34
 * 邮箱：197726885@qq.com
 * 说明：Gilde图片框架
 */
public class GlideUtils {
    /**
     * Gilde加载正常图片
     *
     * @param context 上下文
     * @param imageUrl 图片地址
     * @param imageView 图片控件
     */
    public static void loadNImage(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context).load(imageUrl).placeholder(R.mipmap.ic_launcher).centerCrop().into(imageView);
    }
}
