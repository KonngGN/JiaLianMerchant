package com.example.apple.jialianmerchant.bean.data;

/**
 * 作者：孔先生 on 2017/3/8 13:18
 * 邮箱：197726885@qq.com
 * 说明：生活圈布局数据
 */
public class LifeCircleData {
    private int imageId;
    private String text;
    private String num;

    public LifeCircleData(int imageId, String text, String num) {
        this.imageId = imageId;
        this.text = text;
        this.num = num;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    public String getNum() {
        return num;
    }
}
