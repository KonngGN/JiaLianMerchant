package com.example.apple.jialianmerchant.bean.request;

import com.example.apple.jialianmerchant.constant.MessageConsts;

/**
 * 数据汇总
 */

public class TotalRequest {
    private String SooID;
    private String SooTimeSign;
    private int ShopID;
    private int EmployeeID;
    private String BeginDate;
    private String EndDate;

    public TotalRequest(int shopID, int employeeID, String beginDate, String endDate) {
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
        ShopID = shopID;
        EmployeeID = employeeID;
        BeginDate = beginDate;
        EndDate = endDate;
    }
}
