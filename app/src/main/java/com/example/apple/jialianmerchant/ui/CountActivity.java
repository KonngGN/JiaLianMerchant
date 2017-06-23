package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.CountRequest;
import com.example.apple.jialianmerchant.bean.response.CountBean;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.RegexValidateUtil;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：孔先生 on
 * 邮箱：197726885@qq.com
 * 说明：对账
 */
public class CountActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_count_total_inmoney)
    TextView tvCountTotalInmoney;
    @BindView(R.id.tv_count_day_inmoney)
    TextView tvCountDayInmoney;
    @BindView(R.id.tv_count_week_inmoney)
    TextView tvCountWeekInmoney;
    @BindView(R.id.tv_count_month_inmoney)
    TextView tvCountMonthInmoney;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_reconciliation;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        tvTitle.setText("对账");
        getAccount();
    }

    @OnClick({R.id.iv_back,R.id.rl_count_day, R.id.rl_count_week, R.id.rl_count_month})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.rl_count_day:
                IntentUtils.toActivity(this, BillDetailsActivity.class, KeyConsts.TITLE,"日账单");
                break;
            case R.id.rl_count_week:
                IntentUtils.toActivity(this, BillDetailsActivity.class, KeyConsts.TITLE,"周账单");
                break;
            case R.id.rl_count_month:
                IntentUtils.toActivity(this, BillDetailsActivity.class, KeyConsts.TITLE,"月账单");
                break;
        }
    }

    /**
     * 获取网络数据
     */
    private void getAccount() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.TRADE_GETCOUNT, new CountRequest(1, 0, "2016-01-01", "2017-03-01")
                , new BeanCallback<CountBean>() {
                    @Override
                    public void onResponse(CountBean response, int id) {
                        int success = response.getSuccess();
                        if (success == 1) {
                            accountSetText(response);
                        } else {
                            ToastUtils.shortToast(response.getMsg());
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    /**
     * 赋值
     */
    private void accountSetText(CountBean response) {
        tvCountTotalInmoney.setText(RegexValidateUtil.formatDouble(response.getTotalInMoney()));
        tvCountDayInmoney.setText(RegexValidateUtil.formatDouble(response.getTodayInMoney()));
        tvCountWeekInmoney.setText(RegexValidateUtil.formatDouble(response.getCurrentWeekInMoney()));
        tvCountMonthInmoney.setText(RegexValidateUtil.formatDouble(response.getCurrentMonthInMoney()));
    }

}
