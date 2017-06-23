package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.data.HomeData;
import com.example.apple.jialianmerchant.ui.CollectMoneyActivity;
import com.example.apple.jialianmerchant.ui.DataAggregationActivity;
import com.example.apple.jialianmerchant.ui.InventoryActivity;
import com.example.apple.jialianmerchant.ui.MyMemberActivity;
import com.example.apple.jialianmerchant.ui.MyStoreActivity;
import com.example.apple.jialianmerchant.ui.PayQrcodeActivity;
import com.example.apple.jialianmerchant.ui.ScanServiceActivity;
import com.example.apple.jialianmerchant.utils.ActivityCollector;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;

import java.util.List;

/**
 * 作者：孔先生 on 2017/3/6 17:47
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class HomeGridAdapter extends BaseCommonAdapter<HomeData> {
    public HomeGridAdapter(Context context, int layoutId, List<HomeData> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(RvViewHolder holder, HomeData homeData, final int position) {
        TextView textView = holder.getView(R.id.grid_text);
        LinearLayout linearLayout = holder.getView(R.id.ll_grid);
        ImageView imageView = holder.getView(R.id.grid_image);
        textView.setText(list.get(position).getName());
        imageView.setImageDrawable(ContextCompat.getDrawable(context, list.get(position).getImageID()));

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0://付钱
                        IntentUtils.toActivity(context, PayQrcodeActivity.class);
                        break;
                    case 1://收钱
                        IntentUtils.toActivity(context, CollectMoneyActivity.class);
                        break;
                    case 2://数据汇总
                        IntentUtils.toActivity(context, DataAggregationActivity.class);
                        break;
                    case 3://我的会员
                        IntentUtils.toActivity(context, MyMemberActivity.class);
                        break;
                    case 4://我的门店
                        IntentUtils.toActivity(context, MyStoreActivity.class);
                        break;
                    case 5://扫一扫核销
                        IntentUtils.toActivity(context, ScanServiceActivity.class);
                        break;
                    case 6://库存盘点
                        IntentUtils.toActivity(context, InventoryActivity.class);
                        break;
                    case 7://扫一扫核销
                        ToastUtils.shortToast("测试按钮");
                        break;
                }
            }
        });
    }

}
