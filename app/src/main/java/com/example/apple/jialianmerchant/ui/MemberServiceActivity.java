package com.example.apple.jialianmerchant.ui;

import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;

import butterknife.BindView;

public class MemberServiceActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_member_service;
    }

    @Override
    public void initView() {
        tvTitle.setText("会员服务");
        tvSubTitle.setText("增加");
    }
}
