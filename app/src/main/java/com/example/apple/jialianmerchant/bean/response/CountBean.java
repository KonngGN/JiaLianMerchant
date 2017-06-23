package com.example.apple.jialianmerchant.bean.response;

/**
 * 对账数据
 */

public class CountBean {

    /**
     * TotalInMoney : 400
     * TodayInMoney : 300
     * CurrentWeekInMoney : 300
     * CurrentMonthInMoney : 30000
     * Success : 1
     * Msg :
     * Body :
     */

    private int TotalInMoney;
    private int TodayInMoney;
    private int CurrentWeekInMoney;
    private int CurrentMonthInMoney;
    private int Success;
    private String Msg;
    private String Body;

    public int getTotalInMoney() {
        return TotalInMoney;
    }

    public void setTotalInMoney(int TotalInMoney) {
        this.TotalInMoney = TotalInMoney;
    }

    public int getTodayInMoney() {
        return TodayInMoney;
    }

    public void setTodayInMoney(int TodayInMoney) {
        this.TodayInMoney = TodayInMoney;
    }

    public int getCurrentWeekInMoney() {
        return CurrentWeekInMoney;
    }

    public void setCurrentWeekInMoney(int CurrentWeekInMoney) {
        this.CurrentWeekInMoney = CurrentWeekInMoney;
    }

    public int getCurrentMonthInMoney() {
        return CurrentMonthInMoney;
    }

    public void setCurrentMonthInMoney(int CurrentMonthInMoney) {
        this.CurrentMonthInMoney = CurrentMonthInMoney;
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
