package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.response.ChangeDoutListBean;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.List;

/**
 * 作者：孔先生 on 2017/2/24 15:44
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class ChangedOutAdapter extends BaseAbstractAdapter<ChangeDoutListBean.ChangedListBean> {

    public ChangedOutAdapter(Context context, List<ChangeDoutListBean.ChangedListBean> list) {
        super(context, list, R.layout.item_listview_bill);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        RelativeLayout toDetails = holder.getView(R.id.rl_to_details);
        TextView time = holder.getView(R.id.tv_bill_reconciliationr_time);
        TextView name = holder.getView(R.id.tv_bill_buyer_name);
        ImageView type = holder.getView(R.id.iv_bill_paytype);
        ImageView headpic = holder.getView(R.id.iv_bill_buyer_headpic);
        TextView money = holder.getView(R.id.tv_bill_trade_money);

        ChangeDoutListBean.ChangedListBean changedListBean = list.get(position);

        time.setText(changedListBean.getTheWeek()+"\n"+changedListBean.getTheDay());
        name.setText(changedListBean.getBuyerName());
        money.setText(changedListBean.getTradeMoney());

        HttpUtils.downloadBitmap(changedListBean.getBuyerHeadPic(),headpic);

    }
}
