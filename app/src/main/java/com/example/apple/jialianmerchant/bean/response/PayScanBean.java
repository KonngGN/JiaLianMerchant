package com.example.apple.jialianmerchant.bean.response;

/**
 * 付款二维码
 */

public class PayScanBean {
    /**
     * TradeNo : 80636233822736197755
     * PayStateRequest :
     * Success : 1
     * Msg :
     * Body :
     */

    private String TradeNo;
    private String PayState;
    private int Success;
    private String Msg;
    private String Body;

    public String getTradeNo() {
        return TradeNo;
    }

    public void setTradeNo(String TradeNo) {
        this.TradeNo = TradeNo;
    }

    public String getPayState() {
        return PayState;
    }

    public void setPayState(String PayState) {
        this.PayState = PayState;
    }

    public int getSuccess() {
        return Success;
    }

    public void setSuccess(int Success) {
        this.Success = Success;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }
}
