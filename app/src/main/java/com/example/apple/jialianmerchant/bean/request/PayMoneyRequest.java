package com.example.apple.jialianmerchant.bean.request;


import com.example.apple.jialianmerchant.constant.MessageConsts;

public class PayMoneyRequest {
    private int ShopID;
    private double PayMoney;
    private String SooID;
    private String SooTimeSign;

    public PayMoneyRequest(int shopID, double payMoney) {
        ShopID = shopID;
        PayMoney = payMoney;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }

}
