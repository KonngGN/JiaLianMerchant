package com.example.apple.jialianmerchant.bean.request;

import com.example.apple.jialianmerchant.constant.MessageConsts;

/**
 * 作者：孔先生 on 2017/2/24 15:31
 * 邮箱：197726885@qq.com
 * 说明：消费记录
 */
public class ChangeDoutListRequest {
    private int PageIndex;
    private int PageSize;
    private int ShopID;
    private int EmployeeID;
    private String TradeNo;
    private String BeginDate;
    private String EndDate;
    private String SooID;
    private String SooTimeSign;

    public ChangeDoutListRequest(int pageIndex, int pageSize, int shopID, int employeeID, String tradeNo, String beginDate, String endDate) {
        PageIndex = pageIndex;
        PageSize = pageSize;
        ShopID = shopID;
        EmployeeID = employeeID;
        TradeNo = tradeNo;
        BeginDate = beginDate;
        EndDate = endDate;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }
}
