package com.example.apple.jialianmerchant.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToWithdrawalsActivity extends BaseActivity {


    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_to_withdrawals;
    }

    @Override
    public void initView() {
        tvTitle.setText("我要提现");
        tvSubTitle.setText("提现记录");
    }


    @OnClick({R.id.iv_back, R.id.tv_sub_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_sub_title:
                IntentUtils.toActivity(ToWithdrawalsActivity.this, CashRecordActivity.class);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
