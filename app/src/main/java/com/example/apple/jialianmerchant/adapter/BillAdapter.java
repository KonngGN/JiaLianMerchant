package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.response.BillListBean;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.ui.BillDetailsActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.http.GlideUtils;

import java.util.List;



public class BillAdapter extends BaseAbstractAdapter<BillListBean.MMListBean>{
    public BillAdapter(Context context, List<BillListBean.MMListBean> list) {
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

        String url = "http://lieekimg.oss-cn-hangzhou.aliyuncs.com/00/image/20170116/20170116202849_8101.png";
        GlideUtils.loadNImage(context,url,headpic);
        final BillListBean.MMListBean mmListBean = list.get(position);
        time.setText(mmListBean.getTheWeek()+"\n"+mmListBean.getTheDay());
        name.setText(mmListBean.getBuyerName());
        money.setText(mmListBean.getTradeMoney());

        toBillDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.toActivity(context, BillDetailsActivity.class, KeyConsts.TRADE_NO,mmListBean.getTradeNo(), KeyConsts.TITLE,"收款详情");
            }
        });

    }
}