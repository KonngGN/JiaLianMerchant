package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.PayMoneyRequest;
import com.example.apple.jialianmerchant.bean.response.PayMoneyBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 收款页面二维码
 */
public class PayQrcodeActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_qrcode)
    ImageView ivQrcode;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_pay_qrcode;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        tvTitle.setText("我的二维码");
        getPayQrcode();
    }

    private void getPayQrcode() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.SOOPAY_PAYQRCODE, new PayMoneyRequest(1, 2), new BeanCallback<PayMoneyBean>() {
            @Override
            public void onResponse(PayMoneyBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    String qrCodeUrl = response.getQrCodeUrl();
                    downloadBitmap(qrCodeUrl);
                }
                progressDialog.dismiss();
            }
        });
    }

    private void downloadBitmap(String url) {//获取二维码
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.shortToast(e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        ivQrcode.setImageBitmap(response);
                    }
                });
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        this.finish();
    }
}
