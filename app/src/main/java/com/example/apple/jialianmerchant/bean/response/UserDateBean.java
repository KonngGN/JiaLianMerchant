package com.example.apple.jialianmerchant.bean.response;

/**
 * Created by apple on 2017/2/22.
 */

public class UserDateBean {

    /**
     * TodayInMoney : 400
     * CardAllBanlance : 400
     * YestodayInMoney : 700
     * YesTodaySort : 39
     * Success : 1
     * Msg :
     * Body :
     */

    private int TodayInMoney;
    private int CardAllBanlance;
    private int YestodayInMoney;
    private int YesTodaySort;
    private int Success;
    private String Msg;
    private String Body;

    public int getTodayInMoney() {
        return TodayInMoney;
    }

    public void setTodayInMoney(int TodayInMoney) {
        this.TodayInMoney = TodayInMoney;
    }

    public int getCardAllBanlance() {
        return CardAllBanlance;
    }

    public void setCardAllBanlance(int CardAllBanlance) {
        this.CardAllBanlance = CardAllBanlance;
    }

    public int getYestodayInMoney() {
        return YestodayInMoney;
    }

    public void setYestodayInMoney(int YestodayInMoney) {
        this.YestodayInMoney = YestodayInMoney;
    }

    public int getYesTodaySort() {
        return YesTodaySort;
    }

    public void setYesTodaySort(int YesTodaySort) {
        this.YesTodaySort = YesTodaySort;
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
