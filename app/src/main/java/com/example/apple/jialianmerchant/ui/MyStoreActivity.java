package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.MyStoreAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.ListshopRequest;
import com.example.apple.jialianmerchant.bean.response.ListShopBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyStoreActivity extends BaseActivity {


    @BindView(R.id.ls_my_store)
    ListView lsMyStore;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private List<ListShopBean.MMListBean> list;
    private MyStoreAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_my_store;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        list = new ArrayList<>();
        tvTitle.setText("我的门店");

        adapter = new MyStoreAdapter(this, list);
        lsMyStore.setAdapter(adapter);
        getMyStore(new ListshopRequest( 1, 1));

    }

    private void getMyStore(Object object) {
        progressDialog.show();
        list.clear();
        HttpUtils.post(OperatorConsts.USER_LISTSHOP, object, new BeanCallback<ListShopBean>() {
            @Override
            public void onResponse(ListShopBean response, int id) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        this.finish();
    }
}
