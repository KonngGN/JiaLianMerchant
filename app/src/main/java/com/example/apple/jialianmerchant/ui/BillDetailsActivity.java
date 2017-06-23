package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.DetailsAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.data.DetailsData;
import com.example.apple.jialianmerchant.bean.request.BillDetailsRequest;
import com.example.apple.jialianmerchant.bean.response.BillDetailsBean;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BillDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_details)
    RecyclerView rvDetails;
    @BindView(R.id.iv_buyer_headpic)
    ImageView ivBuyerHeadpic;
    @BindView(R.id.tv_buyer_name)
    TextView tvBuyerName;
    @BindView(R.id.tv_paystate)
    TextView tvPaystate;
    private ProgressDialog progressDialog;
    private List<DetailsData> list;
    private DetailsAdapter adapter;

    @Override
    public int initLayout() {
        return R.layout.activity_billdetails;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        list = new ArrayList<>();
        Intent intent = getIntent();
        String tradeno = intent.getStringExtra(KeyConsts.TRADE_NO);
        String title = intent.getStringExtra(KeyConsts.TITLE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDetails.setLayoutManager(layoutManager);
        adapter = new DetailsAdapter(this, R.layout.item_rv_details, list);
        rvDetails.addItemDecoration(new DividerItemDecoration(this, 1));
        rvDetails.setAdapter(adapter);

        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(tradeno)) {
            getBillDetails(tradeno);
        } else {
            initData();
        }

    }

    private void initData() {

        addList("0.00", "0.01", "浙江加联网络科技有限公司", "2017-1-1", "现金", "11111", "22222", null, null, null);
    }


    /**
     * 布局数据复制
     *
     * @param tradeMoney   交易金额
     * @param payMoney     实收金额
     * @param shopName     门店名称
     * @param payTime      支付时间
     * @param payType      支付类型
     * @param outOrderID   关联外部订单号
     * @param tradeNo      交易号
     * @param buyerName    消费者名称
     * @param payState     支付状态
     * @param buyerHeadPic 消费者头像
     */
    private void addList(String tradeMoney, String payMoney, String shopName, String payTime, String payType,
                         String outOrderID, String tradeNo, String buyerName, String payState, String buyerHeadPic) {
        list.clear();
        list.add(new DetailsData("收款明细", null));
        list.add(new DetailsData("订单金额", tradeMoney));
        list.add(new DetailsData("实收金额", payMoney));
        list.add(new DetailsData("收款信息", null));
        list.add(new DetailsData("收款门店", shopName));
        list.add(new DetailsData("其他信息", null));
        list.add(new DetailsData("付款时间", payTime));
        list.add(new DetailsData("交易类型", payType));
        list.add(new DetailsData("订单号", outOrderID));
        list.add(new DetailsData("交易号", tradeNo));
        tvBuyerName.setText(buyerName);
        if (buyerHeadPic != null) {
            HttpUtils.downloadBitmap(buyerHeadPic, ivBuyerHeadpic);
        }
        tvPaystate.setText(payState);
        adapter.notifyDataSetChanged();
    }

    /**
     * 从网络获取数据
     */
    private void getBillDetails(String tradeno) {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.TRADE_GETMODEL, new BillDetailsRequest(tradeno), new BeanCallback<BillDetailsBean>() {
            @Override
            public void onResponse(BillDetailsBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    addList(String.valueOf(response.getTradeMoney()), String.valueOf(response.getPayMoney()),
                            response.getShopName(), response.getPayTime(), response.getPayType(), response.getOutOrderID(), response.getTradeNo(),
                            response.getBuyerName(), response.getPayState(), response.getBuyerHeadPic());
                } else {
                    ToastUtils.shortToast(response.getMsg());
                }
                progressDialog.dismiss();
            }
        });
    }
}
