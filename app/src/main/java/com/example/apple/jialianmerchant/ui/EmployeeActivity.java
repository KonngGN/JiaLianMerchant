package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.EmployeeAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.ListemployeeRequest;
import com.example.apple.jialianmerchant.bean.response.ListEmployeeBean;
import com.example.apple.jialianmerchant.constant.MessageConsts;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class EmployeeActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ls_employee)
    ListView lsEmployee;

    private List<ListEmployeeBean.MMListBean> list ;
    private EmployeeAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_cashier;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        list = new ArrayList<>();
        tvTitle.setText("收银员");
        adapter = new EmployeeAdapter(this, list);
        lsEmployee.setAdapter(adapter);
        getCashier();
    }

    private void getCashier() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.USER_LISTEMPLOYEE, new ListemployeeRequest(1, 1, 2, MessageConsts.getSooID(), MessageConsts.getSign()), new BeanCallback<ListEmployeeBean>() {
            @Override
            public void onResponse(ListEmployeeBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
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
