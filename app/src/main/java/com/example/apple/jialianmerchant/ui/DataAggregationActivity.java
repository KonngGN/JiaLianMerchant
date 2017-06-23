package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.TotalRequest;
import com.example.apple.jialianmerchant.bean.response.TotalBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class DataAggregationActivity extends BaseActivity {


    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_trade_count)
    TextView tvTradeCount;
    @BindView(R.id.tv_trade_money)
    TextView tvTradeMoney;
    @BindView(R.id.tv_total_inmoney)
    TextView tvTotalInmoney;
    @BindView(R.id.tv_total_paymoney)
    TextView tvTotalPaymoney;
    @BindView(R.id.tv_alipay_val)
    TextView tvAlipayVal;
    @BindView(R.id.tv_wxpay_val)
    TextView tvWxpayVal;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_data_aggregation;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        tvTitle.setText("数据汇总");
        tvSubTitle.setText("选择收银员");
        getTotal();
    }


    @OnClick({R.id.iv_back, R.id.tv_sub_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_sub_title:
                IntentUtils.toActivity(this, EmployeeActivity.class);
                break;
        }
    }

    /**
     * 获取数据
     */
    private void getTotal() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.TRADE_GETTOTAL, new TotalRequest(1, 0, "2016-11-01", "2017-03-01"), new BeanCallback<TotalBean>() {
            @Override
            public void onResponse(TotalBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    tvTradeCount.setText(String.valueOf(response.getTradeCount()));
                    tvTotalInmoney.setText(String.valueOf(response.getTotalInMoney()));
                    tvTradeMoney.setText(String.valueOf(response.getTradeMoney()));
                    tvTotalPaymoney.setText(String.valueOf(response.getTotalPayMoney()));
                    tvAlipayVal.setText("支付宝支付服务费:商家实收的" + response.getAlipayVal() + "%");
                    tvWxpayVal.setText("微信支付服务费:商家实收的" + response.getWxpayVal() + "%");
                } else {
                    ToastUtils.shortToast(response.getMsg());
                }
                progressDialog.dismiss();
            }
        });
    }

}
