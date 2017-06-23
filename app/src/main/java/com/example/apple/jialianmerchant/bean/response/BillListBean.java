package com.example.apple.jialianmerchant.bean.response;

import java.io.Serializable;
import java.util.List;


public class BillListBean {


    /**
     * PageIndex : 1
     * PageSize : 15
     * Count : 0
     * PageCount : 0
     * TotalMoney : 0
     * TotalCount : 0
     * MMList : [{"TradeNo":"80636234454793746519","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"微信","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234451705874733","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"微信","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234448347060245","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"微信","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234446471242980","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"微信","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234445020121369","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234442729921148","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234441313487703","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234440024556706","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234439132508329","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234437182002130","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234437051530875","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"微信","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234436689961433","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234436578709297","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"微信","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234433148018429","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"微信","TradeType":"","TradeMoney":"0.01"},{"TradeNo":"80636234432047528550","TheMonth":"月","TheWeek":"星期三","TheDay":"20","BuyerHeadPic":"","BuyerName":"3333","PayType":"","TradeType":"","TradeMoney":"0.01"}]
     * Success : 1
     * Msg :
     * Body :
     */

    private int PageIndex;
    private int PageSize;
    private int Count;
    private int PageCount;
    private int TotalMoney;
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
         * TradeNo : 80636234454793746519
         * TheMonth : 月
         * TheWeek : 星期三
         * TheDay : 20
         * BuyerHeadPic :
         * BuyerName : 3333
         * PayType : 微信
         * TradeType :
         * TradeMoney : 0.01
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
