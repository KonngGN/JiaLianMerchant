package com.example.apple.jialianmerchant.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：孔先生 on
 * 邮箱：197726885@qq.com
 * 说明：添加活动
 */
public class AddActivityActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_add_activity;
    }

    @Override
    public void initView() {
        tvTitle.setText(R.string.add_activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
