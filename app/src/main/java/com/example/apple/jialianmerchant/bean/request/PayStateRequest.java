package com.example.apple.jialianmerchant.bean.request;

import com.example.apple.jialianmerchant.constant.MessageConsts;

/**
 * 交易状态
 */

public class PayStateRequest {
    private String TradeNo;
    private String SooID;
    private String SooTimeSign;

    public PayStateRequest(String tradeNo) {
        TradeNo = tradeNo;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }
}
