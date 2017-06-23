package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.response.AllMemberBean;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.List;

/**
 * 作者：孔先生 on 2017/2/24 16:27
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class AllMemberAdapter extends BaseAbstractAdapter<AllMemberBean.MMListBean> {

    public AllMemberAdapter(Context context, List<AllMemberBean.MMListBean> list) {
        super(context, list, R.layout.item_listview_all_member);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        LinearLayout toDetails = holder.getView(R.id.ll_to_details);
        ImageView headpic = holder.getView(R.id.iv_headpic);
        TextView name_times = holder.getView(R.id.tv_name_times);
        TextView banlance = holder.getView(R.id.tv_banlance);

        name_times.setText(list.get(position).getName()+"\n"+list.get(position).getPayTimes());
        banlance.setText(String.valueOf(list.get(position).getBanlance()));

        HttpUtils.downloadBitmap(list.get(position).getHeadPic(),headpic);

        toDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
