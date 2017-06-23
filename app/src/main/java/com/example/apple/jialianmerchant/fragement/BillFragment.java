package com.example.apple.jialianmerchant.fragement;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.BillAdapter;
import com.example.apple.jialianmerchant.base.BaseFragement;
import com.example.apple.jialianmerchant.bean.request.BillListRequest;
import com.example.apple.jialianmerchant.bean.response.BillListBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.ui.CountActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：孔先生 on
 * 邮箱：197726885@qq.com
 * 说明：账单
 */
public class BillFragment extends BaseFragement {

    @BindView(R.id.tv_left_subtitle)
    TextView tvLeftSubtitle;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ls_bill)
    PullToRefreshListView lsBill;
    @BindView(R.id.rl_title_view)
    RelativeLayout rlTitleView;
    @BindView(R.id.cardViewSearch)
    CardView cardViewSearch;
    @BindView(R.id.et_search_content)
    EditText etSearchContent;
    @BindView(R.id.iv_fork_clear)
    ImageView ivForkClear;
    private List<BillListBean.MMListBean> list;
    private BillAdapter adapter;
    private ProgressDialog progressDialog;
    private int pageSize = 0;
    private int page = 1;


    public static BillFragment newInstance() {
        return new BillFragment();
    }


    @Override
    protected void initData() {
        list = new ArrayList<>();

        adapter = new BillAdapter(getActivity(), list);
        lsBill.setMode(PullToRefreshBase.Mode.BOTH);
        lsBill.setAdapter(adapter);
        lsBill.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (page > 1) {
                    page--;
                }
                getBillList(page, true);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (pageSize > page) {
                    page++;
                    getBillList(page, false);
                } else {
                    ToastUtils.shortToast("没有更多了");
                    if (lsBill != null) {
                        lsBill.onRefreshComplete();
                    }
                }
            }
        });
        getBillList(page, true);
    }

    @Override
    protected void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(getActivity());
        tvTitle.setText(R.string.my_bill);
        tvLeftSubtitle.setText(R.string.reconciliation);

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_bill;
    }


    @OnClick({R.id.tv_left_subtitle, R.id.iv_search, R.id.iv_arrow_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_left_subtitle:
                IntentUtils.toActivity(getActivity(), CountActivity.class);
                break;
            case R.id.iv_search:
                rlTitleView.setVisibility(View.GONE);
                cardViewSearch.setVisibility(View.VISIBLE);
                break;

            case R.id.iv_arrow_back:
                rlTitleView.setVisibility(View.VISIBLE);
                cardViewSearch.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 获取账单数据，下拉刷新是list清空，上啦则不清空
     */
    private void getBillList(int page, boolean clearn) {
        if (clearn) {
            list.clear();
        }
        progressDialog.show();
        HttpUtils.post(OperatorConsts.TRADE_GETLIST, new BillListRequest(page, 10, 1, 0, "", "2016-01-01", "2017-04-01"), new BeanCallback<BillListBean>() {
                    @Override
                    public void onResponse(BillListBean response, int id) {
                        pageSize = response.getPageSize();
                        int success = response.getSuccess();
                        if (success == 1) {
                            list.addAll(response.getMMList());
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.shortToast(response.getMsg());
                        }
                        progressDialog.dismiss();
                        lsBill.onRefreshComplete();
                    }
                }

        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.iv_arrow_back)
    public void onClick() {
    }
}
