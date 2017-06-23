package com.example.apple.jialianmerchant.bean.response;


import java.util.List;

public class MyStoreBean {

    /**
     * PageIndex : 1
     * PageSize : 15
     * Count : 0
     * PageCount : 0
     * MMList : []
     * Success : -9
     * Msg : The type Client.AppB.Request.User.ListShopRequest doesn't have the property 'pageindex'
     * Body :
     */

    private int PageIndex;
    private int PageSize;
    private int Count;
    private int PageCount;
    private int Success;
    private String Msg;
    private String Body;
    private List<?> MMList;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int PageCount) {
        this.PageCount = PageCount;
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

    public List<?> getMMList() {
        return MMList;
    }

    public void setMMList(List<?> MMList) {
        this.MMList = MMList;
    }
}
