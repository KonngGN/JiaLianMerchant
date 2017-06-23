package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.response.MessageListBean;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.ui.WebActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.List;


public class MessageAdapter extends BaseAbstractAdapter<MessageListBean.MMListBean> {
    public MessageAdapter(Context context, List<MessageListBean.MMListBean> list) {
        super(context, list, R.layout.item_list_message);
    }

    @Override
    public void convert(ViewHolder holder, final int position) {
        CardView toWebView = holder.getView(R.id.card_view);
        TextView title = holder.getView(R.id.tv_message_title);
        TextView date = holder.getView(R.id.tv_message_date);
        TextView descript = holder.getView(R.id.tv_message_descript);
        ImageView pic = holder.getView(R.id.iv_message_pic);
        title.setText(list.get(position).getTitle());
        date.setText(list.get(position).getDate());
        descript.setText(list.get(position).getDescript());

        HttpUtils.downloadBitmap(list.get(position).getPic(),pic);


        toWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.toActivity(context, WebActivity.class, KeyConsts.WEB_URL,list.get(position).getUrl());
            }
        });
    }
}
