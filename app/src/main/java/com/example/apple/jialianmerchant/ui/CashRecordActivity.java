package com.example.apple.jialianmerchant.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CashRecordActivity extends BaseActivity {


    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_cash_record;
    }

    @Override
    public void initView() {
        tvTitle.setText("提现记录");
        tvSubTitle.setText("筛选");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
