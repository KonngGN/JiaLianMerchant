package com.example.apple.jialianmerchant.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VariousRechargeActivity extends BaseActivity {


    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_various_recharge;
    }

    @Override
    public void initView() {
        String from = getIntent().getStringExtra("from");
        tvTitle.setText(from);
        tvSubTitle.setText("选择门店");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_sub_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_sub_title:
                ToastUtils.shortToast("");
                break;
        }
    }
}
