package com.example.apple.jialianmerchant.bean.response;


public class GetSoodataBean {

    /**
     * 用户信用数据
     *
     * XinYongVal : 3000
     * Suggest : 建议多使用移动支付
     * Success : 1
     * Msg :
     * Body :
     */

    private int XinYongVal;
    private String Suggest;
    private int Success;
    private String Msg;
    private String Body;

    public int getXinYongVal() {
        return XinYongVal;
    }

    public void setXinYongVal(int XinYongVal) {
        this.XinYongVal = XinYongVal;
    }

    public String getSuggest() {
        return Suggest;
    }

    public void setSuggest(String Suggest) {
        this.Suggest = Suggest;
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
