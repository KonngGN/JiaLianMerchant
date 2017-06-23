package com.example.apple.jialianmerchant.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class CashAccountActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.ll_to_withdrawals)
    LinearLayout llToWithdrawals;

    @Override
    public int initLayout() {
        return R.layout.activity_cash_account;
    }

    @Override
    public void initView() {
        tvTitle.setText("提现账户");
    }


    @OnClick({R.id.iv_back, R.id.ll_to_withdrawals,R.id.ll_to_cash_record})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.ll_to_withdrawals:
                IntentUtils.toActivity(CashAccountActivity.this, ToWithdrawalsActivity.class);
                break;
            case R.id.ll_to_cash_record:
                IntentUtils.toActivity(CashAccountActivity.this, CashRecordActivity.class);
                break;
        }
    }

}
