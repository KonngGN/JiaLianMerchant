package com.example.apple.jialianmerchant.ui;

import android.view.View;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MyActivity extends BaseActivity {


    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_my;
    }

    @Override
    public void initView() {
        tvTitle.setText("我的活动");
        tvSubTitle.setText("添加");
    }


    @OnClick({R.id.iv_back, R.id.tv_sub_title, R.id.btn_start})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_sub_title:
                IntentUtils.toActivity(MyActivity.this,AddActivityActivity.class);
                break;
            case R.id.btn_start:
                break;
        }
    }
}
