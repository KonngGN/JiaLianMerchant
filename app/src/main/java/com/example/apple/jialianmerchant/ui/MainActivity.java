package com.example.apple.jialianmerchant.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.fragement.BillFragment;
import com.example.apple.jialianmerchant.fragement.HomeFragment;
import com.example.apple.jialianmerchant.fragement.MessageFragment;
import com.example.apple.jialianmerchant.fragement.MineFragment;
import com.example.apple.jialianmerchant.utils.ActivityCollector;
import com.example.apple.jialianmerchant.utils.FragmentUtils;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Main
 */

public class MainActivity extends BaseActivity {


    @BindView(R.id.fragment_list)
    FrameLayout fragmentList;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;


    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setActiveColor(R.color.main_green)
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_livingarea_home, R.string.main_home))
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_account_books, R.string.main_bill))
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_message, R.string.main_message))
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_me, R.string.main_mine))
                .setFirstSelectedPosition(0)
                .initialise();
        boolean isLogin = SharedPreferencesUtils.getLoginMessage().getBoolean(KeyConsts.ALREADY_LOGGED, false);

        if (!isLogin) {
            IntentUtils.toActivity(this, LoginActivity.class);
        }

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(HomeFragment.newInstance());
        mFragmentList.add(BillFragment.newInstance());
        mFragmentList.add(MessageFragment.newInstance());
        mFragmentList.add(MineFragment.newInstance());

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        new FragmentUtils(supportFragmentManager, mFragmentList, R.id.fragment_list, bottomNavigationBar).getFragment();
    }
    // 设置第一次按的时间
    long currentMillions = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 第一次的时间
            if (System.currentTimeMillis() - currentMillions > 2000) {
                Toast.makeText(getApplicationContext(), "请再按一次退出", Toast.LENGTH_SHORT).show();
                // 获取第二次点击的时间 然后判断两次时间差
                currentMillions = System.currentTimeMillis();
            } else {
                ActivityCollector.finishALL(ActivityCollector.allActivity);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
