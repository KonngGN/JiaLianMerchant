package com.example.apple.jialianmerchant.bean.data;

/**
 * 作者：孔先生 on 2017/3/7 10:39
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class HomeData {
    private int imageID;
    private String name;

    public HomeData(int imageID, String name) {
        this.imageID = imageID;
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }
}
