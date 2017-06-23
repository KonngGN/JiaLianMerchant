package com.example.apple.jialianmerchant.ui;

import android.view.View;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class StoreDetailsActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_store_details;
    }

    @Override
    public void initView() {
        tvTitle.setText("门店详情");
    }


    @OnClick({R.id.iv_back, R.id.ll_to_collect_money})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.ll_to_collect_money:
                break;
        }
    }
}
