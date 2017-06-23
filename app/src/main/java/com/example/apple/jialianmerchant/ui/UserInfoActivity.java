package com.example.apple.jialianmerchant.ui;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.UserInfoAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.data.UserInfoData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_info)
    RecyclerView rvInfo;

    @Override
    public int initLayout() {
        return R.layout.activity_userinfo;
    }

    @Override
    public void initView() {
        tvTitle.setText("用户信息");
        initDate();
    }

    private void initDate() {
        List<UserInfoData> list = new ArrayList<>();
        list.add(new UserInfoData("用户名", null));
        list.add(new UserInfoData("用户名", "表哥"));
        list.add(new UserInfoData("公司名称", "加联网络科技有限公司"));
        list.add(new UserInfoData("用户名", "表哥"));
        list.add(new UserInfoData(null, null));
        list.add(new UserInfoData("手机", "138"));
        list.add(new UserInfoData("QQ", "1726391737"));
        list.add(new UserInfoData("邮箱", "1977263838@qq.com"));
        list.add(new UserInfoData(null, null));
        list.add(new UserInfoData("修改密码", null));
        list.add(new UserInfoData(null, null));
        list.add(new UserInfoData("所属代理商", "杭州加联"));
        list.add(new UserInfoData("创建时间", "2017-1-1"));
        list.add(new UserInfoData("账户有效期", "2018-1-1"));
        UserInfoAdapter adapter = new UserInfoAdapter(this, R.layout.item_rv_text_text, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvInfo.setLayoutManager(layoutManager);
        rvInfo.addItemDecoration(new DividerItemDecoration(this,1));
        rvInfo.setAdapter(adapter);
    }

}
