package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.AllMemberAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.AllMemberRequest;
import com.example.apple.jialianmerchant.bean.response.AllMemberBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：孔先生 on
 * 邮箱：197726885@qq.com
 * 说明：所有会员
 */

public class AllMemberActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_line_all_member)
    TextView tvLineAllMember;
    @BindView(R.id.tv_line_active_member)
    TextView tvLineActiveMember;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_sub_all_member)
    TextView tvSubAllMember;
    @BindView(R.id.tv_sub_active_member)
    TextView tvSubActiveMember;
    @BindView(R.id.tv_all_member)
    TextView tvAllMember;
    @BindView(R.id.tv_active_member)
    TextView tvActiveMember;
    @BindView(R.id.ls_all_member)
    ListView lsAllMember;

    private List<AllMemberBean.MMListBean> list;
    private AllMemberAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_all_member;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        list = new ArrayList<>();
        tvTitle.setText(R.string.all_member);
//        chooseColor();
        getAllMember();
        adapter = new AllMemberAdapter(this, list);
        lsAllMember.setAdapter(adapter);
    }


    /**
     * 获取数据
     */
    private void getAllMember() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.VIP_GETLIST, new AllMemberRequest(1, 1, "", ""), new BeanCallback<AllMemberBean>() {
            @Override
            public void onResponse(AllMemberBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    tvActiveMember.setText(response.getActiveCount() + "");
                    tvAllMember.setText(response.getAllCount() + "");
                    list.addAll(response.getMMList());
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.shortToast(response.getMsg());
                }
                progressDialog.dismiss();
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.rl_all_member, R.id.rl_active_member})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.rl_all_member:
//                isCheck = false;
//                chooseColor();
                break;
            case R.id.rl_active_member:
//                isCheck = true;
//                chooseColor();
                break;
        }
    }
    //    private void chooseColor() {//点击切换颜色,暂不需要
//        if (isCheck) {
//            tvAllMember.setTextColor(ContextCompat.getColor(this, R.color.black));
//            tvSubAllMember.setTextColor(ContextCompat.getColor(this, R.color.black));
//            tvActiveMember.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
//            tvSubActiveMember.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
//            tvLineAllMember.setVisibility(View.INVISIBLE);
//            tvLineActiveMember.setVisibility(View.VISIBLE);
//        } else {
//            tvAllMember.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
//            tvSubAllMember.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
//            tvActiveMember.setTextColor(ContextCompat.getColor(this, R.color.black));
//            tvSubActiveMember.setTextColor(ContextCompat.getColor(this, R.color.black));
//            tvLineAllMember.setVisibility(View.VISIBLE);
//            tvLineActiveMember.setVisibility(View.INVISIBLE);
//        }
//    }
}
