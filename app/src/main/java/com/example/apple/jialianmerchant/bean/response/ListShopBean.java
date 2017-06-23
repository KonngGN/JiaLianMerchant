package com.example.apple.jialianmerchant.bean.response;

import java.io.Serializable;
import java.util.List;


public class ListShopBean implements Serializable{


    /**
     * PageIndex : 1
     * PageSize : 15
     * Count : 5
     * PageCount : 1
     * MMList : [{"ShopID":12,"ShopName":"","ShopOwnerName":"","ShopOwnerTel":""},{"ShopID":11,"ShopName":"","ShopOwnerName":"","ShopOwnerTel":""},{"ShopID":10,"ShopName":"","ShopOwnerName":"","ShopOwnerTel":""},{"ShopID":3,"ShopName":"1号门店0","ShopOwnerName":"","ShopOwnerTel":""},{"ShopID":2,"ShopName":"1号门店","ShopOwnerName":"","ShopOwnerTel":""}]
     * Success : 1
     * Msg :
     * Body :
     */

    private int PageIndex;
    private int PageSize;
    private int Count;
    private int PageCount;
    private int Success;
    private String Msg;
    private String Body;
    private List<MMListBean> MMList;

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

    public List<MMListBean> getMMList() {
        return MMList;
    }

    public void setMMList(List<MMListBean> MMList) {
        this.MMList = MMList;
    }

    public static class MMListBean implements Serializable{
        /**
         * ShopID : 12
         * ShopName :
         * ShopOwnerName :
         * ShopOwnerTel :
         */

        private int ShopID;
        private String ShopName;
        private String ShopOwnerName;
        private String ShopOwnerTel;

        public int getShopID() {
            return ShopID;
        }

        public void setShopID(int ShopID) {
            this.ShopID = ShopID;
        }

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String ShopName) {
            this.ShopName = ShopName;
        }

        public String getShopOwnerName() {
            return ShopOwnerName;
        }

        public void setShopOwnerName(String ShopOwnerName) {
            this.ShopOwnerName = ShopOwnerName;
        }

        public String getShopOwnerTel() {
            return ShopOwnerTel;
        }

        public void setShopOwnerTel(String ShopOwnerTel) {
            this.ShopOwnerTel = ShopOwnerTel;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
