package com.example.apple.jialianmerchant.bean.response;

import java.util.List;


public class ListEmployeeBean {

    /**
     * PageIndex : 1
     * PageSize : 15
     * Count : 3
     * PageCount : 1
     * MMList : [{"EmployeeID":11,"EmployeeName":"888","EmployeeTel":"15988445558"},{"EmployeeID":8,"EmployeeName":"张三","EmployeeTel":"15988445558"},{"EmployeeID":7,"EmployeeName":"36677","EmployeeTel":"15988445558"}]
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
         * EmployeeID : 11
         * EmployeeName : 888
         * EmployeeTel : 15988445558
         */

        private int EmployeeID;
        private String EmployeeName;
        private String EmployeeTel;

        public int getEmployeeID() {
            return EmployeeID;
        }

        public void setEmployeeID(int EmployeeID) {
            this.EmployeeID = EmployeeID;
        }

        public String getEmployeeName() {
            return EmployeeName;
        }

        public void setEmployeeName(String EmployeeName) {
            this.EmployeeName = EmployeeName;
        }

        public String getEmployeeTel() {
            return EmployeeTel;
        }

        public void setEmployeeTel(String EmployeeTel) {
            this.EmployeeTel = EmployeeTel;
        }
    }
}
