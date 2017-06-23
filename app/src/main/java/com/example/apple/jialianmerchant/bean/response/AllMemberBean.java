package com.example.apple.jialianmerchant.bean.response;

import java.util.List;

/**
 * 作者：孔先生 on 2017/2/24 16:09
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class AllMemberBean {

    /**
     * PageIndex : 1
     * PageSize : 15
     * Count : 0
     * PageCount : 0
     * AllCount : 0
     * ActiveCount : 0
     * MMList : [{"HeadPic":"https://zos.alipayobjects.com/rmsportal/roCFucDzSlyeqAD.png","Name":"111","PayTimes":33,"Banlance":81}]
     * Success : 1
     * Msg :
     * Body :
     */

    private int PageIndex;
    private int PageSize;
    private int Count;
    private int PageCount;
    private int AllCount;
    private int ActiveCount;
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

    public int getAllCount() {
        return AllCount;
    }

    public void setAllCount(int AllCount) {
        this.AllCount = AllCount;
    }

    public int getActiveCount() {
        return ActiveCount;
    }

    public void setActiveCount(int ActiveCount) {
        this.ActiveCount = ActiveCount;
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

    public static class MMListBean {
        /**
         * HeadPic : https://zos.alipayobjects.com/rmsportal/roCFucDzSlyeqAD.png
         * Name : 111
         * PayTimes : 33
         * Banlance : 81
         */

        private String HeadPic;
        private String Name;
        private int PayTimes;
        private int Banlance;

        public String getHeadPic() {
            return HeadPic;
        }

        public void setHeadPic(String HeadPic) {
            this.HeadPic = HeadPic;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getPayTimes() {
            return PayTimes;
        }

        public void setPayTimes(int PayTimes) {
            this.PayTimes = PayTimes;
        }

        public int getBanlance() {
            return Banlance;
        }

        public void setBanlance(int Banlance) {
            this.Banlance = Banlance;
        }
    }
}
