package com.example.apple.jialianmerchant.bean.request;

import com.example.apple.jialianmerchant.constant.MessageConsts;

/**
 * 对账数据
 * */

public class CountRequest {
    private int ShopID;
    private int EmployeeID;
    private String BeginDate;
    private String EndDate;
    private String SooID;
    private String SooTimeSign;

    public CountRequest(int shopID, int employeeID, String beginDate, String endDate) {
        ShopID = shopID;
        EmployeeID = employeeID;
        BeginDate = beginDate;
        EndDate = endDate;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }
}
