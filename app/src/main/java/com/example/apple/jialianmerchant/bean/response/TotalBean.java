package com.example.apple.jialianmerchant.bean.response;

/**
 * 数据汇总
 */

public class TotalBean {

    /**
     * TotalPayMoney : 4000
     * TotalInMoney : 2999
     * TradeCount : 600
     * TradeMoney : 600
     * AlipayVal : 0.006
     * WxpayVal : 0.006
     * Success : 1
     * Msg :
     * Body :
     */

    private int TotalPayMoney;
    private int TotalInMoney;
    private int TradeCount;
    private int TradeMoney;
    private String AlipayVal;
    private String WxpayVal;
    private int Success;
    private String Msg;
    private String Body;

    public int getTotalPayMoney() {
        return TotalPayMoney;
    }

    public void setTotalPayMoney(int TotalPayMoney) {
        this.TotalPayMoney = TotalPayMoney;
    }

    public int getTotalInMoney() {
        return TotalInMoney;
    }

    public void setTotalInMoney(int TotalInMoney) {
        this.TotalInMoney = TotalInMoney;
    }

    public int getTradeCount() {
        return TradeCount;
    }

    public void setTradeCount(int TradeCount) {
        this.TradeCount = TradeCount;
    }

    public int getTradeMoney() {
        return TradeMoney;
    }

    public void setTradeMoney(int TradeMoney) {
        this.TradeMoney = TradeMoney;
    }

    public String getAlipayVal() {
        return AlipayVal;
    }

    public void setAlipayVal(String AlipayVal) {
        this.AlipayVal = AlipayVal;
    }

    public String getWxpayVal() {
        return WxpayVal;
    }

    public void setWxpayVal(String WxpayVal) {
        this.WxpayVal = WxpayVal;
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
