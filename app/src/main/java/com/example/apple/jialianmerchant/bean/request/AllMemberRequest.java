package com.example.apple.jialianmerchant.bean.request;

import com.example.apple.jialianmerchant.constant.MessageConsts;

/**
 * 作者：孔先生 on 2017/2/24 16:04
 * 邮箱：197726885@qq.com
 * 说明：所有会员
 */
public class AllMemberRequest {
    private int PageIndex;
    private int PageSize;
    private String MemberNo;
    private String MemberName;
    private String SooID;
    private String SooTimeSign;

    public AllMemberRequest(int pageIndex, int pageSize, String memberNo, String memberName) {
        PageIndex = pageIndex;
        PageSize = pageSize;
        MemberNo = memberNo;
        MemberName = memberName;
        SooID = MessageConsts.getSooID();
        SooTimeSign = MessageConsts.getSign();
    }
}
