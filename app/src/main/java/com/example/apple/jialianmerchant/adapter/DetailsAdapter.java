package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.data.DetailsData;

import java.util.List;

/**
 * 作者：孔先生 on 2017/3/7 15:00
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class DetailsAdapter extends BaseCommonAdapter<DetailsData> {

    public DetailsAdapter(Context context, int layoutId, List<DetailsData> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(RvViewHolder holder, DetailsData detailsData, int position) {
        TextView tvLeft = holder.getView(R.id.tv_details_left);
        TextView tvRight = holder.getView(R.id.tv_details_right);
        RelativeLayout relativeLayout = holder.getView(R.id.rl_details);
        tvLeft.setText(detailsData.getTextLeft());
        tvRight.setText(detailsData.getTextRight());
        if (detailsData.getTextRight() == null) {
            tvLeft.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }
}
