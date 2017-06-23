package com.example.apple.jialianmerchant.bean.data;

/**
 * 作者：孔先生 on 2017/3/7 17:42
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class MineData {
    private int imageId;
    private String text;
    private String subText;

    public MineData(int imageId, String text, String subText) {
        this.imageId = imageId;
        this.text = text;
        this.subText = subText;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    public String getSubText() {
        return subText;
    }
}
