package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.response.RechargeRecordBean;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.ui.BillDetailsActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.List;


public class RechargeRecordAdapter extends BaseAbstractAdapter<RechargeRecordBean.MMListBean>{
    public RechargeRecordAdapter(Context context, List<RechargeRecordBean.MMListBean> list) {
        super(context, list, R.layout.item_listview_bill);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        RelativeLayout toBillDetails = holder.getView(R.id.rl_to_details);
        TextView time = holder.getView(R.id.tv_bill_reconciliationr_time);
        TextView name = holder.getView(R.id.tv_bill_buyer_name);
        ImageView type = holder.getView(R.id.iv_bill_paytype);
        ImageView headpic = holder.getView(R.id.iv_bill_buyer_headpic);
        TextView money = holder.getView(R.id.tv_bill_trade_money);

        final RechargeRecordBean.MMListBean mmListBean = list.get(position);
        time.setText(mmListBean.getTheWeek()+"\n"+mmListBean.getTheDay());
        name.setText(mmListBean.getBuyerName());
        money.setText(mmListBean.getTradeMoney());
        HttpUtils.downloadBitmap(mmListBean.getBuyerHeadPic(),headpic);


        toBillDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.toActivity(context, BillDetailsActivity.class, KeyConsts.TRADE_NO,mmListBean.getTradeNo(), KeyConsts.TITLE,"收款详情");
            }
        });

    }
}
