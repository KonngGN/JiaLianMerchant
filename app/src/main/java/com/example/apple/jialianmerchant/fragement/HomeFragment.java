package com.example.apple.jialianmerchant.fragement;


import android.app.ProgressDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.HomeGridAdapter;
import com.example.apple.jialianmerchant.adapter.LifeCircleAdapter;
import com.example.apple.jialianmerchant.base.BaseFragement;
import com.example.apple.jialianmerchant.bean.data.HomeData;
import com.example.apple.jialianmerchant.bean.data.LifeCircleData;
import com.example.apple.jialianmerchant.bean.response.UserDateBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.listener.MyClickListener;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.RegexValidateUtil;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 作者：孔先生 on 2017/3/8 13:18
 * 邮箱：197726885@qq.com
 * 说明：HomeFragment 首页布局、生活圈部分布局由recyclerView生成
 */
public class HomeFragment extends BaseFragement {


    @BindView(R.id.iv_to_life_circle)
    ImageView ivToLifeCircle;
    @BindView(R.id.iv_back_home)
    ImageView ivBackHome;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.ll_home_pager)
    LinearLayout llHomePager;
    @BindView(R.id.ll_circle)
    LinearLayout llCircle;
    @BindView(R.id.ptr_scroll_home)
    PullToRefreshScrollView ptrScrollHome;
    @BindView(R.id.rv_life_circle)
    RecyclerView rvLifeCircle;
    @BindView(R.id.tv_home_money)
    TextView tvHomeMoney;
    private ProgressDialog progressDialog;
    private List<LifeCircleData> lifeCircleDataList;
    private LifeCircleAdapter lifeCircleAdapter;
    private List<HomeData> homeDataList;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(getActivity());
        lifeCircleDataList = new ArrayList<>();
        homeDataList = new ArrayList<>();
        homeLayout();
        lifeCircleLayout();
        getUserData();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @OnClick({R.id.iv_to_life_circle, R.id.iv_back_home})
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 添加了下拉刷新后，位置关系会出现失效，用屏幕尺寸来判定
             */
            case R.id.iv_to_life_circle://生活圈
                WindowManager windowManager = getActivity().getWindowManager();
                DisplayMetrics outMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(outMetrics);
                llCircle.setMinimumHeight(outMetrics.heightPixels - 200);
                getUserData();
                llHomePager.setVisibility(View.GONE);
                llCircle.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_back_home://返回首页
                llHomePager.setVisibility(View.VISIBLE);
                llCircle.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 获取生活圈数据
     */
    private void getUserData() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.USER_GETUSERDATA, new BeanCallback<UserDateBean>() {
            @Override
            public void onResponse(UserDateBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {

                    String cardAllBanlance = RegexValidateUtil.formatDouble(response.getCardAllBanlance());
                    String yesTodayInMoney = RegexValidateUtil.formatDouble(response.getYestodayInMoney());
                    String todayInMoney = RegexValidateUtil.formatDouble(response.getTodayInMoney());
                    String string = getResources().getString(R.string.str_tvyestodaysort);
                    String yesTodaySort = String.format(string, response.getYesTodaySort() + "%");
                    textSet(cardAllBanlance, yesTodayInMoney, todayInMoney, yesTodaySort);
                } else {
                    ToastUtils.shortToast(response.getMsg());
                }
                done();
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                super.onError(call, e, id);
                done();
            }
        });
    }

    /**
     * 生活圈布局数据
     */
    private void lifeCircleLayout() {
        lifeCircleAdapter = new LifeCircleAdapter(getActivity(), R.layout.item_rv_life_ciecle, lifeCircleDataList);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        rvLifeCircle.setLayoutManager(layoutManager);
        rvLifeCircle.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        rvLifeCircle.setAdapter(lifeCircleAdapter);
        textSet("0", "0", "0", "0");
    }

    /**
     * 首页布局数据
     */
    private void homeLayout() {
        HomeGridAdapter homeGridAdapter = new HomeGridAdapter(getActivity(), R.layout.item_home_grid, homeDataList);
        homeDataList.add(new HomeData(R.mipmap.home_collect_money_icon, "付款"));
        homeDataList.add(new HomeData(R.mipmap.home_payment_icon, "收钱"));
        homeDataList.add(new HomeData(R.mipmap.home_dataaggregation_icon, "数据汇总"));
        homeDataList.add(new HomeData(R.mipmap.home_mymember_icon, "我的会员"));
        homeDataList.add(new HomeData(R.mipmap.home_store_management_icon, "门店管理"));
        homeDataList.add(new HomeData(R.mipmap.icon_scan_service, "扫一扫核销"));
        homeDataList.add(new HomeData(R.mipmap.home_getuser_icon, "库存盘点"));
        homeDataList.add(new HomeData(R.mipmap.ic_launcher, "测试按钮"));
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 6);
        //设置每行占位空间
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 3;
                } else if (position == 1) {
                    return 3;
                }
                return (2);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeGridAdapter);
        ptrScrollHome.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                getUserData();
            }
        });
    }

    /**
     * 生活圈数据赋值
     *
     * @param cardAllBanlance 今日累计
     * @param yesTodayInMoney 会员卡余额
     * @param todayInMoney    昨日收入
     * @param yesTodaySort    昨日排名
     */
    private void textSet(String cardAllBanlance, String yesTodayInMoney, String todayInMoney, String yesTodaySort) {
        lifeCircleDataList.clear();
        lifeCircleDataList.add(new LifeCircleData(R.mipmap.home_cumulative, "今日累计  (元)", todayInMoney));
        lifeCircleDataList.add(new LifeCircleData(R.mipmap.home_cumulative, "会员卡余额(元)", cardAllBanlance));
        lifeCircleDataList.add(new LifeCircleData(R.mipmap.home_lifecircle_yesterday, "昨日收入(元)", yesTodayInMoney));
        lifeCircleDataList.add(new LifeCircleData(R.mipmap.home_lifecircle_yesterdayrank, "昨日排名", yesTodaySort));
        tvHomeMoney.setText(todayInMoney);
        lifeCircleAdapter.notifyDataSetChanged();
    }

    /**
     * 进度条还原
     */
    private void done() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if (ptrScrollHome != null && ptrScrollHome.isRefreshing()) {
            ptrScrollHome.onRefreshComplete();
        }
    }
}
