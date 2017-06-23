package com.example.apple.jialianmerchant.bean.request;


import com.example.apple.jialianmerchant.constant.MessageConsts;

public class PayScanRequest  {
    private int ShopID;
    private double PayMoney;
    private String ScanNo;
    private String SooID;
    private String SooTimeSign;

    public PayScanRequest(int shopID, double payMoney, String scanNo) {
        ShopID = shopID;
        PayMoney = payMoney;
        ScanNo = scanNo;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }

}
