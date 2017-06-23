package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.data.UserInfoData;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.GlideUtils;

import java.util.List;

/**
 * 作者：孔先生 on 2017/3/7 11:09
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class UserInfoAdapter extends BaseCommonAdapter<UserInfoData> {
    public UserInfoAdapter(Context context, int layoutId, List<UserInfoData> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(RvViewHolder holder, UserInfoData userInfoData, final int position) {
        TextView tvLeft = holder.getView(R.id.tv_text_left);
        TextView tvRight = holder.getView(R.id.tv_text_right);
        RelativeLayout relativeLayout = holder.getView(R.id.ll_info);
        tvLeft.setText(userInfoData.getTextLeft());
        tvRight.setText(userInfoData.getTextRight());
        if (position == 0) {
            tvRight.setBackgroundResource(R.mipmap.ic_launcher);
        }
        if (position == 9) {
            tvRight.setBackgroundResource(R.drawable.ic_to_right);
        }
        if (userInfoData.getTextLeft() == null && userInfoData.getTextLeft() == null) {
            tvLeft.setVisibility(View.GONE);
            tvRight.setVisibility(View.GONE);
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.windowbackground));
        }

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        ToastUtils.shortToast("头像");
                        break;
                    case 9:
                        ToastUtils.shortToast("修改密码");
                        break;
                }
            }
        });

    }

}
