package com.example.apple.jialianmerchant.bean.response;

/**
 * Created by apple on 2017/2/20.
 */

public class LoginBean {

    /**
     * SooID : 888
     * SooTimeSign : 636232053058985145
     * Success : 1
     * Msg :
     * Body :
     */

    private String SooID;
    private String SooTimeSign;
    private int Success;
    private String Msg;
    private String Body;

    public String getSooID() {
        return SooID;
    }

    public void setSooID(String SooID) {
        this.SooID = SooID;
    }

    public String getSooTimeSign() {
        return SooTimeSign;
    }

    public void setSooTimeSign(String SooTimeSign) {
        this.SooTimeSign = SooTimeSign;
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
