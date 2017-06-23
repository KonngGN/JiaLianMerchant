package com.example.apple.jialianmerchant.bean.response;

import java.util.List;

/**
 * 充值记录
 */

public class RechargeRecordBean {

    /**
     * PageIndex : 1
     * PageSize : 15
     * Count : 0
     * PageCount : 0
     * TotalMoney : 4000
     * TotalRealInMoney : 60000
     * TotalCount : 300
     * MMList : [{"TradeNo":"55","TheMonth":"55","TheWeek":"55","TheDay":"44","BuyerHeadPic":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","BuyerName":"dd","PayType":"ff","TradeType":"55","TradeMoney":"11"}]
     * Success : 1
     * Msg :
     * Body :
     */

    private int PageIndex;
    private int PageSize;
    private int Count;
    private int PageCount;
    private int TotalMoney;
    private int TotalRealInMoney;
    private int TotalCount;
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

    public int getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(int TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public int getTotalRealInMoney() {
        return TotalRealInMoney;
    }

    public void setTotalRealInMoney(int TotalRealInMoney) {
        this.TotalRealInMoney = TotalRealInMoney;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
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
         * TradeNo : 55
         * TheMonth : 55
         * TheWeek : 55
         * TheDay : 44
         * BuyerHeadPic : https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png
         * BuyerName : dd
         * PayType : ff
         * TradeType : 55
         * TradeMoney : 11
         */

        private String TradeNo;
        private String TheMonth;
        private String TheWeek;
        private String TheDay;
        private String BuyerHeadPic;
        private String BuyerName;
        private String PayType;
        private String TradeType;
        private String TradeMoney;

        public String getTradeNo() {
            return TradeNo;
        }

        public void setTradeNo(String TradeNo) {
            this.TradeNo = TradeNo;
        }

        public String getTheMonth() {
            return TheMonth;
        }

        public void setTheMonth(String TheMonth) {
            this.TheMonth = TheMonth;
        }

        public String getTheWeek() {
            return TheWeek;
        }

        public void setTheWeek(String TheWeek) {
            this.TheWeek = TheWeek;
        }

        public String getTheDay() {
            return TheDay;
        }

        public void setTheDay(String TheDay) {
            this.TheDay = TheDay;
        }

        public String getBuyerHeadPic() {
            return BuyerHeadPic;
        }

        public void setBuyerHeadPic(String BuyerHeadPic) {
            this.BuyerHeadPic = BuyerHeadPic;
        }

        public String getBuyerName() {
            return BuyerName;
        }

        public void setBuyerName(String BuyerName) {
            this.BuyerName = BuyerName;
        }

        public String getPayType() {
            return PayType;
        }

        public void setPayType(String PayType) {
            this.PayType = PayType;
        }

        public String getTradeType() {
            return TradeType;
        }

        public void setTradeType(String TradeType) {
            this.TradeType = TradeType;
        }

        public String getTradeMoney() {
            return TradeMoney;
        }

        public void setTradeMoney(String TradeMoney) {
            this.TradeMoney = TradeMoney;
        }
    }
}
