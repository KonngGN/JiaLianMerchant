package com.example.apple.jialianmerchant.bean.request;

import com.example.apple.jialianmerchant.constant.MessageConsts;

/**
 * 账单详情
 */

public class BillDetailsRequest {
    private String TradeNo;
    private String SooID;
    private String SooTimeSign;

    public BillDetailsRequest(String tradeNo) {
        TradeNo = tradeNo;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }
}
