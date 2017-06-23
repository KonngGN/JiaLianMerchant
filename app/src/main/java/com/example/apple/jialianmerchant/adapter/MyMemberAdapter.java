package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.data.MyMemberData;
import com.example.apple.jialianmerchant.ui.AllMemberActivity;
import com.example.apple.jialianmerchant.ui.MemberServiceActivity;
import com.example.apple.jialianmerchant.ui.MemberShipcardTemplateActivity;
import com.example.apple.jialianmerchant.ui.MyActivity;
import com.example.apple.jialianmerchant.ui.RechargeRecordActivity;
import com.example.apple.jialianmerchant.ui.RecordsOfConsumptionActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;

import java.util.List;

/**
 * 作者：孔先生 on 2017/3/7 14:19
 * 邮箱：197726885@qq.com
 * 说明：我的会员RecyclerView的适配器
 */
public class MyMemberAdapter extends BaseCommonAdapter<MyMemberData> {
    public MyMemberAdapter(Context context, int layoutId, List<MyMemberData> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(RvViewHolder holder, MyMemberData myMemberData, final int position) {
        ImageView pic = holder.getView(R.id.iv_pic);
        TextView name = holder.getView(R.id.tv_name);
        ImageView toRight = holder.getView(R.id.iv_to_right);
        RelativeLayout relativeLayout = holder.getView(R.id.rl_mymember_item);
        if (myMemberData.getTvName() != null) {
            pic.setImageResource(myMemberData.getImageID());
            name.setText(myMemberData.getTvName());
            toRight.setImageResource(myMemberData.getSubImageId());
        } else {
            pic.setVisibility(View.GONE);
            name.setVisibility(View.GONE);
            toRight.setVisibility(View.GONE);
            relativeLayout.setBackgroundResource(R.color.windowbackground);
        }

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 1:
                        IntentUtils.toActivity(context, MemberServiceActivity.class);
                        break;
                    case 3:
                        IntentUtils.toActivity(context, AllMemberActivity.class);
                        break;
                    case 4:
                        IntentUtils.toActivity(context, MyActivity.class);
                        break;
                    case 6:
                        IntentUtils.toActivity(context, RecordsOfConsumptionActivity.class);
                        break;
                    case 7:
                        IntentUtils.toActivity(context, RechargeRecordActivity.class);
                        break;
                    case 9:
                        IntentUtils.toActivity(context, MemberShipcardTemplateActivity.class);
                        break;
                }
            }
        });
    }
}
