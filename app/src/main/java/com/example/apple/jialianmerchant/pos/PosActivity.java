package com.example.apple.jialianmerchant.pos;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.PayScanRequest;
import com.example.apple.jialianmerchant.bean.request.PayStateRequest;
import com.example.apple.jialianmerchant.bean.response.PayScanBean;
import com.example.apple.jialianmerchant.bean.response.PayStatebean;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import butterknife.BindView;
import butterknife.OnClick;
import woyou.aidlservice.jiuiv5.ICallback;
import woyou.aidlservice.jiuiv5.IWoyouService;

/**
 * 支付信息页面,pos机打印
 */
public class PosActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.loading_progress)
    ContentLoadingProgressBar loadingProgress;
    @BindView(R.id.iv_state)
    ImageView ivState;
    @BindView(R.id.btn_back)
    Button btnBack;
    private IWoyouService woyouService;

    private ICallback callback = null;

    private final int EMPTY_CODE = 1;

    private ServiceConnection connService = null;

    private Intent intentService = null;

    private String scanno;

    private boolean print;

    private Runnable r;
    private Handler handler = new Handler() {


        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case EMPTY_CODE:
                    final String tradeNo = (String) msg.obj;
                    r = new Runnable() {
                        @Override
                        public void run() {
                            getState(tradeNo);
                        }
                    };
                    handler.postDelayed(r, 1000);
                    break;
            }
        }
    };


    @Override
    public int initLayout() {
        return R.layout.activity_pos;
    }

    @Override
    public void initView() {
        tvTitle.setText("支付信息");
        getDatas();
    }

    /**
     * 获取intent数据
     */
    private void getDatas() {
        Intent datas = getIntent();
        scanno = datas.getStringExtra(KeyConsts.SCAN_NO);
        double money = datas.getDoubleExtra(KeyConsts.MONEY, 0);
        print = datas.getBooleanExtra(KeyConsts.SUPPORT_PRINT, false);
        if (print) {
            initPos();
        }
        getPayScan(1, money, scanno);

    }

    /**
     * 支付结果
     */
    private void paymentResults(String state) {
        if ("已支付".equals(state)) {
            loadingProgress.hide();
            ivState.setVisibility(View.VISIBLE);
            tvState.setText(state);
        } else {
            loadingProgress.hide();
            ivState.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pay_fail));
            ivState.setVisibility(View.VISIBLE);
            tvState.setText(state);
        }
        btnBack.setBackgroundColor(ContextCompat.getColor(this, R.color.money_green));
    }

    /**
     * 开始支付
     */
    private void getPayScan(int shopID, final double money, final String scanno) {//开始支付
        HttpUtils.post(OperatorConsts.SOOPAY_PAYSCAN, new PayScanRequest(shopID, money, scanno),
                new BeanCallback<PayScanBean>() {
                    @Override
                    public void onResponse(PayScanBean response, int id) {
                        int success = response.getSuccess();
                        if (success == 1) {
                            String payState = response.getPayState();
                            if ("已支付".equals(payState)) {
                                ToastUtils.shortToast(payState);
                                paymentResults(payState);
                                toPrint();
                            } else {
                                getState(response.getTradeNo());
                            }
                        } else {
                            ToastUtils.shortToast(response.getMsg());
                            paymentResults(response.getMsg());
                        }
                    }
                });
    }

    /**
     * 循环查询用户是否支付
     */
    private void getState(String str) {
        final String tradeNo = str;
        HttpUtils.post(OperatorConsts.SOOPAY_GETSTATE, new PayStateRequest(tradeNo), new BeanCallback<PayStatebean>() {
            @Override
            public void onResponse(PayStatebean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    String payState = response.getPayState();
                    if ("已支付".equals(payState)) {
                        ToastUtils.shortToast(payState);
                        paymentResults(payState);
                        toPrint();
                    } else {
                        Message message = handler.obtainMessage();
                        message.obj = tradeNo;
                        message.what = EMPTY_CODE;
                        handler.sendMessage(message);
                    }
                } else {
                    ToastUtils.shortToast(response.getMsg());
                    paymentResults(response.getMsg());
                }
            }
        });
    }

    /**
     * 打印机初始化,绑定服务
     */
    private void initPos() {
        connService = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {

                woyouService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                woyouService = IWoyouService.Stub.asInterface(service);
            }
        };

        callback = new ICallback.Stub() {

            @Override
            public void onRunResult(final boolean success) throws RemoteException {
            }

            @Override
            public void onReturnString(final String value) throws RemoteException {
            }

            @Override
            public void onRaiseException(int code, final String msg) throws RemoteException {
            }
        };

        intentService = new Intent();
        intentService.setPackage("woyou.aidlservice.jiuiv5");
        intentService.setAction("woyou.aidlservice.jiuiv5.IWoyouService");
        startService(intentService);
        bindService(intentService, connService, Context.BIND_AUTO_CREATE);
    }

    /**
     * 打印文字
     */
    private void toPrint() {

        if (!print) {
            return;
        }
        //打印文字
        ThreadPoolManager.getInstance().executeTask(new Runnable() {

            @Override
            public void run() {
                try {
                    woyouService.lineWrap(2, callback);
                    woyouService.printTextWithFont(scanno + "\n", "", 30, callback);
                    woyouService.lineWrap(4, callback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.btn_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_back:
                this.finish();
                break;
        }
    }

    //打印文字
    private void printText() {
        ThreadPoolManager.getInstance().executeTask(new Runnable() {

            @Override
            public void run() {
                try {
                    woyouService.printText("您前面还有", callback);
                    woyouService.printTextWithFont("28", "", 36, callback);
                    woyouService.printText("位在等待\n", callback);
                    for (int i = 24; i <= 48; i += 6) {
                        woyouService.printTextWithFont("商米", "", i, callback);
                    }
                    for (int i = 48; i >= 12; i -= 2) {
                        woyouService.printTextWithFont("商米", "", i, callback);
                    }
                    woyouService.lineWrap(1, callback);
                    woyouService.printTextWithFont("ABCDEFGHIJKLMNOPQRSTUVWXYZ01234\n", "", 30, callback);
                    woyouService.printTextWithFont("abcdefghijklmnopqrstuvwxyz56789\n", "", 30, callback);
                    woyouService.printText("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789\n", callback);
                    woyouService.printText("abcdefghijklmnopqrstuvwxyz0123456789\n", callback);

                    woyouService.lineWrap(2, callback);
                    woyouService.setAlignment(1, callback);
                    woyouService.setFontSize(24, callback);
                    woyouService.printTextWithFont("歡迎開啟打印機測試\n", "", 35, callback);
                    woyouService.setAlignment(0, callback);
                    woyouService.printTextWithFont("*****************************\n", "", 24, callback);
                    woyouService.printTextWithFont("这是一行正常字体\n", "", 24, callback);
                    woyouService.printTextWithFont("這是一行30號字體\n", "", 30, callback);
                    woyouService.printTextWithFont("这是一行36号字体\n", "", 36, callback);
                    woyouService.printTextWithFont("这是一行42号字体\n", "", 42, callback);
                    //woyouService.printTextWithFont("*****************************\n", "", 24, callback);
                    woyouService.sendRAWData(BytesUtil.initLine2(384), callback);
                    woyouService.setAlignment(1, callback);
                    woyouService.printBarCode("2015112910", 8, 100, 2, 2, callback);
                    woyouService.printTextWithFont("\n\n", "", 24, callback);
                    woyouService.setAlignment(1, callback);
                    woyouService.printTextWithFont("***Completed***\n", "", 35, callback);
                    for (int i = 0; i < 12; i++) {
                        woyouService.sendRAWData(BytesUtil.initLine1(384, i), callback);
                    }
                    String[] s = woyouService.getServiceVersion().split("\\.");
                    int ver = 10000 * Integer.parseInt(s[0])
                            + 100 * Integer.parseInt(s[1])
                            + Integer.parseInt(s[2]);

                    //printOriginalText方法是1.7.6版本新加的，用于字符原宽度输出，即不作等宽处理
                    if (ver >= 10706) {
                        woyouService.setFontSize(36, callback);
                        woyouService.printOriginalText("κρχκμνκλρκνκνμρτυφ\n", callback);
                        woyouService.printOriginalText("http://www.sunmi.com\n", callback);
                        woyouService.printOriginalText("这是一行36号字体\n這是一行36號字體\n", callback);
                        woyouService.setFontSize(24, callback);
                        woyouService.printOriginalText("κρχκμνκλρκνκνμρτυφ\n", callback);
                        woyouService.printOriginalText("http://www.sunmi.com\n", callback);
                        woyouService.printOriginalText("这是一行正常字体\n這是一行正常字體\n", callback);
                    }

                    Log.i("PrinterTestDemo", "version = " + woyouService.getServiceVersion() + "\nlength=" + s.length);

                    woyouService.lineWrap(4, callback);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * 退出界面后  取消handler的循环耗时操作
     * 停止服务取消服务绑定
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(r);
        if (intentService != null) {
            stopService(intentService);
        }
        if (connService != null) {
            unbindService(connService);
        }
    }
}
