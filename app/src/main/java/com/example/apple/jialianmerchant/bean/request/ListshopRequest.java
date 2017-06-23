package com.example.apple.jialianmerchant.bean.request;


import com.example.apple.jialianmerchant.constant.MessageConsts;

public class ListshopRequest {
    private String SooID;
    private String SooTimeSign;
    private int PageIndex;
    private int PageSize;


    public ListshopRequest( int pageindex, int pagesize) {
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
        this.PageIndex = pageindex;
        this.PageSize = pagesize;
    }
}
