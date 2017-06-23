package com.example.apple.jialianmerchant.bean.response;

import java.util.List;

/**
 * 消息列表
 */

public class MessageListBean {

    /**
     * PageIndex : 1
     * PageSize : 0
     * Count : 2
     * PageCount : 1
     * MMList : [{"Title":"dddd","Pic":"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2386980517,467285709&fm=80&w=179&h=119&img.JPEG","Descript":"ddddd","Url":"http://www.baidu.com","Date":""},{"Title":"dddd","Pic":"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2386980517,467285709&fm=80&w=179&h=119&img.JPEG","Descript":"ddddd","Url":"http://www.baidu.com","Date":""}]
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

    public static class MMListBean {
        /**
         * Title : dddd
         * Pic : https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2386980517,467285709&fm=80&w=179&h=119&img.JPEG
         * Descript : ddddd
         * Url : http://www.baidu.com
         * Date :
         */

        private String Title;
        private String Pic;
        private String Descript;
        private String Url;
        private String Date;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getPic() {
            return Pic;
        }

        public void setPic(String Pic) {
            this.Pic = Pic;
        }

        public String getDescript() {
            return Descript;
        }

        public void setDescript(String Descript) {
            this.Descript = Descript;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }
    }
}
