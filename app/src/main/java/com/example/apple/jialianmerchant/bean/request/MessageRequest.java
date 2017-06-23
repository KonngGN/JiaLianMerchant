package com.example.apple.jialianmerchant.bean.request;


import com.example.apple.jialianmerchant.constant.MessageConsts;

public class MessageRequest {
    private String MsgType;
    private String PageIndex;
    private String PageSize;
    private String SooID;
    private String SooTimeSign;

    public MessageRequest(String msgType, String pageIndex, String pageSize) {
        MsgType = msgType;
        PageIndex = pageIndex;
        PageSize = pageSize;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }

}
