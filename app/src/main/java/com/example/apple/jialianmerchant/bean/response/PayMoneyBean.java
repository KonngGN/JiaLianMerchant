package com.example.apple.jialianmerchant.bean.response;


public class PayMoneyBean {

    /**
     * TradeNo : 1234
     * QrCodeUrl : https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png
     * Success : 1
     * Msg :
     * Body :
     */

    private String TradeNo;
    private String QrCodeUrl;
    private int Success;
    private String Msg;
    private String Body;

    public String getTradeNo() {
        return TradeNo;
    }

    public void setTradeNo(String TradeNo) {
        this.TradeNo = TradeNo;
    }

    public String getQrCodeUrl() {
        return QrCodeUrl;
    }

    public void setQrCodeUrl(String QrCodeUrl) {
        this.QrCodeUrl = QrCodeUrl;
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
