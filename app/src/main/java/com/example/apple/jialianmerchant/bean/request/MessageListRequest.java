package com.example.apple.jialianmerchant.bean.request;

import com.example.apple.jialianmerchant.constant.MessageConsts;
/**
 * 消息列表
 */

public class MessageListRequest {
    private String SooID;
    private String SooTimeSign;
    private int MsgType;
    private int PageIndex;
    private int PageSize;

    public MessageListRequest(int msgType, int pageIndex, int pageSize) {
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
        MsgType = msgType;
        PageIndex = pageIndex;
        PageSize = pageSize;
    }
}
