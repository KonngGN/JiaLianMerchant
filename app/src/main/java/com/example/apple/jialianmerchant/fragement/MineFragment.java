package com.example.apple.jialianmerchant.fragement;


import android.Manifest;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.MineAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.base.BaseFragement;
import com.example.apple.jialianmerchant.bean.data.MineData;
import com.example.apple.jialianmerchant.constant.StringConsts;
import com.example.apple.jialianmerchant.listener.MyClickListener;
import com.example.apple.jialianmerchant.listener.PermissionListener;
import com.example.apple.jialianmerchant.ui.LoginActivity;
import com.example.apple.jialianmerchant.ui.UserInfoActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.PhoneDialogUtils;
import com.example.apple.jialianmerchant.utils.UpdateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：孔先生 on
 * 邮箱：197726885@qq.com
 * 说明：我的
 */
public class MineFragment extends BaseFragement {

    @BindView(R.id.tv_subtitle)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    //    @BindView(R.id.ll_user_info)
//    LinearLayout llUserInfo;
    @BindView(R.id.rv_mine)
    RecyclerView rvMine;
//    @BindView(R.id.swipe_layout)
//    SwipeRefreshLayout swipeLayout;
//    @BindView(R.id.pull_scroll)
//    PullToRefreshScrollView pullToRefreshScrollView;

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvTitle.setText(R.string.me);
        tvSubTitle.setText(R.string.sign_out);
        buildLayout();
    }

    /**
     * 布局生成
     */
    private void buildLayout() {
        List<MineData> list = new ArrayList<>();
        list.add(new MineData(R.mipmap.ic_launcher, "名字", null));
        list.add(new MineData(0, null, null));
        list.add(new MineData(R.drawable.voice_setting, "当前版本", "版本号: 1.1.1"));
        list.add(new MineData(R.drawable.icon_setting_suggestions, "意见反馈", null));
        list.add(new MineData(R.drawable.icon_setting_relationsever, "联系客服", null));
        list.add(new MineData(R.drawable.voice_setting, "设置", null));

        MineAdapter adapter = new MineAdapter(getActivity(), R.layout.item_rv_image_text_text, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMine.setLayoutManager(layoutManager);
        rvMine.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        rvMine.setAdapter(adapter);
        adapter.setItemClick(new MyClickListener() {
            @Override
            public void MyClick(int position) {
                switch (position) {
                    case 0:
                        IntentUtils.toActivity(getActivity(), UserInfoActivity.class);
                        break;
                    case 2:
                        UpdateUtils.post(getActivity());
                        //下面方法会出现暂时重复下载失败还未解决
//                UpdateApkUtils.downloadApk(getActivity(),"http://oeoqi3ryr.bkt.clouddn.com/yinyuebofangqi.apk","播放器","bofnagqi.apk");
                        break;
                    case 4:
                        call();
                        break;
                }
            }
        });

    }

    /**
     * 拨打电话调用运行时权限
     */
    private void call() {
        BaseActivity.requestRuntimePermission(new String[]{Manifest.permission.CALL_PHONE}, new PermissionListener() {
            @Override
            public void onGranted() {
                PhoneDialogUtils.getPhoneDialog(getActivity(), String.valueOf(R.string.contact_customer_service), StringConsts.KE_FU);
            }

//            @Override
//            public void onDenied(List<String> deniedPermission) {
//
//            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.tv_subtitle)
    public void onClick() {
        IntentUtils.toActivity(getActivity(), LoginActivity.class);
    }
}
