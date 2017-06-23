package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.RechargeRecordAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.RechargeRecordRequest;
import com.example.apple.jialianmerchant.bean.response.RechargeRecordBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * 充值记录
 * */
public class RechargeRecordActivity extends BaseActivity {


    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_total_realmoney)
    TextView tvTotalRealmoney;
    @BindView(R.id.ls_recharge_record)
    ListView lsRechargeRecord;

    private List<RechargeRecordBean.MMListBean> list;
    private RechargeRecordAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_recharge_record;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        list = new ArrayList<>();
        tvTitle.setText("充值记录");
        tvSubTitle.setText("选择门店");
        getRechargeRecord();
        adapter = new RechargeRecordAdapter(this, list);
        lsRechargeRecord.setAdapter(adapter);
    }


    @OnClick({R.id.iv_back, R.id.rl_to_recharge_type})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.rl_to_recharge_type:
                IntentUtils.toActivity(this, RechargeTypeActivity.class);
                break;
        }
    }

    private void getRechargeRecord() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.VIP_CHANGEDINLIST, new RechargeRecordRequest(1, 1, 1, 0, "", "2016-11-11", "2017-03-01"), new BeanCallback<RechargeRecordBean>() {
            @Override
            public void onResponse(RechargeRecordBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    tvTotalMoney.setText(response.getTotalMoney()+"");
                    tvTotalRealmoney.setText(response.getTotalRealInMoney()+"");
                    list.addAll(response.getMMList());
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.shortToast(response.getMsg());
                }
                progressDialog.dismiss();

            }
        });
    }

}
