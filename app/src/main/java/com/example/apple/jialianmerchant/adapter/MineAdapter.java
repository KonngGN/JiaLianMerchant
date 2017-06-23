package com.example.apple.jialianmerchant.adapter;

import android.Manifest;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.data.MineData;
import com.example.apple.jialianmerchant.constant.StringConsts;
import com.example.apple.jialianmerchant.listener.PermissionListener;
import com.example.apple.jialianmerchant.utils.LogUtil;
import com.example.apple.jialianmerchant.utils.PhoneDialogUtils;
import com.example.apple.jialianmerchant.utils.http.GlideUtils;

import java.util.List;

/**
 * 作者：孔先生 on 2017/3/7 17:51
 * 邮箱：197726885@qq.com
 * 说明：
 */
public class MineAdapter extends BaseCommonAdapter<MineData> {

    //    public MyClickListener myClickListener;
    public MineAdapter(Context context, int layoutId, List<MineData> list) {
        super(context, layoutId, list);
    }

    @Override
    public void convert(RvViewHolder holder, MineData mineData, final int position) {
        RelativeLayout relativeLayout = holder.getView(R.id.rl_mine);
        ImageView imageView = holder.getView(R.id.iv_pic);
        TextView text = holder.getView(R.id.tv_name);
        TextView subText = holder.getView(R.id.tv_to_right);
        text.setText(mineData.getText());
        subText.setText(mineData.getSubText());
        imageView.setImageResource(mineData.getImageId());
        if (position == 0) {
            String url = "http://lieekimg.oss-cn-hangzhou.aliyuncs.com/00/image/20170116/20170116202849_8101.png";
            GlideUtils.loadNImage(context,url,imageView);
        }
        if (mineData.getImageId() == 0) {
            text.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
            subText.setVisibility(View.GONE);
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.windowbackground));
        }
        if (mineData.getSubText() == null) {
            subText.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_to_right));
        }
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myClickListener != null) {
                    myClickListener.MyClick(position);
                }
            }
        });


//                relativeLayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        switch (position) {
//                            case 0:
//                                IntentUtils.toActivity(context, UserInfoActivity.class);
//                                break;
//                            case 2:
//                                UpdateUtils.post(context);
//                                //下面方法会出现暂时重复下载失败还未解决
////                UpdateApkUtils.downloadApk(getActivity(),"http://oeoqi3ryr.bkt.clouddn.com/yinyuebofangqi.apk","播放器","bofnagqi.apk");
//                                break;
//                            case 4:
//                                call();
//                                break;
//                        }
//                        myClickListener.MyClick(position);
//                    }
//                });
    }

    /**
     * 拨打电话调用运行时权限
     */
    private void call() {
        BaseActivity.requestRuntimePermission(new String[]{Manifest.permission.CALL_PHONE}, new PermissionListener() {
            @Override
            public void onGranted() {
                PhoneDialogUtils.getPhoneDialog(context, String.valueOf(R.string.contact_customer_service), StringConsts.KE_FU);
            }

//            @Override
//            public void onDenied(List<String> deniedPermission) {
//
//            }
        });

    }

//    public void setItemClick(MyClickListener myClickListener) {
//        this.myClickListener= myClickListener;
//    }
}
