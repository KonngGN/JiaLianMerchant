package com.example.apple.jialianmerchant.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MemberShipcardTemplateActivity extends BaseActivity {


    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_member_shipcard_template;
    }

    @Override
    public void initView() {
        tvTitle.setText("模板设置");
        tvSubTitle.setText("预览");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
