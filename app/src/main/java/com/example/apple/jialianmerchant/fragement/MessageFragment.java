package com.example.apple.jialianmerchant.fragement;


import android.app.ProgressDialog;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.MessageAdapter;
import com.example.apple.jialianmerchant.base.BaseFragement;
import com.example.apple.jialianmerchant.bean.request.MessageListRequest;
import com.example.apple.jialianmerchant.bean.response.MessageListBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MessageFragment extends BaseFragement {


    @BindView(R.id.tv_subtitle)
    TextView tvSubtitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ls_message_list)
    PullToRefreshListView listView;

    private List<MessageListBean.MMListBean> list;
    private MessageAdapter adapter;
    private ProgressDialog progressDialog;
    private int page;
    private int pageSize;

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }


    @Override
    protected void initData() {
        list = new ArrayList<>();
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(getActivity());
        adapter = new MessageAdapter(getActivity(), list);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setAdapter(adapter);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (page > 1) {
                    page = 1;
                }
                getMessage(page, true);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (pageSize > page) {
                    page++;
                    getMessage(page, false);
                } else {
                    ToastUtils.shortToast("没有更多了");
                    if (listView != null) {
                        listView.onRefreshComplete();
                    }
                }
            }
        });
        getMessage(page, true);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        tvTitle.setText(R.string.message);
        listView.setNullDividerHeight();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_message;
    }

    private void getMessage(int page, boolean clearn) {
        progressDialog.show();
        if (clearn) {
            list.clear();
        }
        HttpUtils.post(OperatorConsts.MESSAGE_GETLIST, new MessageListRequest(0, page, 0), new BeanCallback<MessageListBean>() {
            @Override
            public void onResponse(MessageListBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    pageSize = response.getPageSize();
                    list.addAll(response.getMMList());
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.shortToast(response.getMsg());
                }
                progressDialog.dismiss();
                listView.onRefreshComplete();
            }
        });
    }

    @OnClick(R.id.tv_subtitle)
    public void onClick() {
        getMessage(page, true);
    }
}
