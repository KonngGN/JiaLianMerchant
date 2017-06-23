package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.data.LifeCircleData;

import java.util.List;

/**
 * 作者：孔先生 on 2017/3/8 13:34
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class LifeCircleAdapter extends BaseCommonAdapter<LifeCircleData> {

    public LifeCircleAdapter(Context context, int layoutId, List<LifeCircleData> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(RvViewHolder holder, LifeCircleData lifeCircleData, int position) {
        ImageView imageView = holder.getView(R.id.iv_life_circle);
        TextView text = holder.getView(R.id.tv_life_circle_text);
        TextView num = holder.getView(R.id.tv_life_circle_num);
        imageView.setImageResource(lifeCircleData.getImageId());
        text.setText(lifeCircleData.getText());
        num.setText(lifeCircleData.getNum());
    }
}
