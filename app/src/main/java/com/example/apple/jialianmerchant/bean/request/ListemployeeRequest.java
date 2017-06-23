package com.example.apple.jialianmerchant.bean.request;


public class ListemployeeRequest {
    private int PageIndex;
    private int PageSize;
    private int ShopID;
    private String SooID;
    private String SooTimeSign;

    public ListemployeeRequest(int pageIndex, int pageSize, int shopID, String sooID, String sooTimeSign) {
        PageIndex = pageIndex;
        PageSize = pageSize;
        ShopID = shopID;
        SooID = sooID;
        SooTimeSign = sooTimeSign;
    }

}
