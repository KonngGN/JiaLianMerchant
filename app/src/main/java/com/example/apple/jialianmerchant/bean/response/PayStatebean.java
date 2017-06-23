package com.example.apple.jialianmerchant.bean.response;

/**
 * 支付状态
 */

public class PayStatebean {

    /**
     * PayState : 已支付
     * Success : 1
     * Msg :
     * Body :
     */

    private String PayState;
    private int Success;
    private String Msg;
    private String Body;

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
