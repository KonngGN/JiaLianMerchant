package com.example.apple.jialianmerchant.bean.data;

/**
 * 作者：孔先生 on 2017/3/7 14:13
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class MyMemberData {
    private int imageID;
    private String tvName;
    private int subImageId;

    public MyMemberData(int imageID, String tvName, int subImageId) {
        this.imageID = imageID;
        this.tvName = tvName;
        this.subImageId = subImageId;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTvName() {
        return tvName;
    }

    public int getSubImageId() {
        return subImageId;
    }
}
