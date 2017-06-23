package com.example.apple.jialianmerchant.ui;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.MyMemberAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.data.MyMemberData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyMemberActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_mymember)
    RecyclerView rvMymember;

    @Override
    public int initLayout() {
        return R.layout.activity_my_member;
    }

    @Override
    public void initView() {
        tvTitle.setText(R.string.my_member);
        List<MyMemberData> list = new ArrayList<>();
        list.add(new MyMemberData(0, null, 0));
        list.add(new MyMemberData(R.mipmap.inconfont_memberservice, "会员服务", R.drawable.ic_to_right));
        list.add(new MyMemberData(0, null, 0));
        list.add(new MyMemberData(R.mipmap.iconfont_allmember, "所有会员", R.drawable.ic_to_right));
        list.add(new MyMemberData(R.mipmap.my_activity_icon, "我的活动", R.drawable.ic_to_right));
        list.add(new MyMemberData(0, null, 0));
        list.add(new MyMemberData(R.mipmap.iconfont_consumptionrecord, "消费记录", R.drawable.ic_to_right));
        list.add(new MyMemberData(R.mipmap.iconfont_prepaidrecord, "充值记录", R.drawable.ic_to_right));
        list.add(new MyMemberData(0, null, 0));
        list.add(new MyMemberData(R.mipmap.member_card_template_icon, "会员卡模板", R.drawable.ic_to_right));
        MyMemberAdapter adapter = new MyMemberAdapter(this, R.layout.item_rv_image_text_image, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMymember.setLayoutManager(layoutManager);
        rvMymember.addItemDecoration(new DividerItemDecoration(this, 1));
        rvMymember.setAdapter(adapter);
    }


    @OnClick(R.id.iv_back)
    public void onClick() {
        this.finish();
    }
}