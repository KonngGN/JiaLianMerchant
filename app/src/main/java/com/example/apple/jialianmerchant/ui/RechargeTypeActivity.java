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

public class RechargeTypeActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_recharge_type;
    }

    @Override
    public void initView() {
        tvTitle.setText("充值类型");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_to_conventional_recharge, R.id.ll_recharge_send, R.id.ll_to_consumption_returns, R.id.ll_to_activation_bonus, R.id.ll_to_recommended_rewards})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_to_conventional_recharge:
                IntentUtils.toActivity(this,VariousRechargeActivity.class,"from","常规充值");
                break;
            case R.id.ll_recharge_send:
                IntentUtils.toActivity(this,VariousRechargeActivity.class,"from","充值满送");
                break;
            case R.id.ll_to_consumption_returns:
                IntentUtils.toActivity(this,VariousRechargeActivity.class,"from","消费返现");
                break;
            case R.id.ll_to_activation_bonus:
                IntentUtils.toActivity(this,VariousRechargeActivity.class,"from","激活奖励");
                break;
            case R.id.ll_to_recommended_rewards:
                IntentUtils.toActivity(this,VariousRechargeActivity.class,"from","推荐奖励");
                break;
        }
    }
}
