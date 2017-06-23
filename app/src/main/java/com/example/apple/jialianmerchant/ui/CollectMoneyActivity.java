package com.example.apple.jialianmerchant.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.base.BaseApp;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.listener.PermissionListener;
import com.example.apple.jialianmerchant.pos.PosActivity;
import com.example.apple.jialianmerchant.utils.AlgorithmUtils;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.zxing.CaptureActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收款界面,计算器，扫码入口
 */
public class CollectMoneyActivity extends BaseActivity {


    @BindView(R.id.et_collect_money)
    EditText etCollectMoney;
    @BindView(R.id.et_collect_not_involved_money)
    EditText etCollectNotInvolvedMoney;
    @BindView(R.id.ivbtn_calcuator_del)
    ImageButton ivbtnCalcuatorDel;

    private EditText editText;
    private String money;
    private Double resultMoney;
    private String n1;
    private String n2;
    private final int EDIT_TYPE_CODE = 1;
    private final int POS_CODE = 2;
    private final int CAMERA_CODE = 3;

    private String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    /**
     * handler关闭软键盘
     *
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case EDIT_TYPE_CODE:
                    closeKeyBord(editText, CollectMoneyActivity.this);
                    editText.setSelection(editText.length());
                    break;
            }
        }
    };


    @Override
    public int initLayout() {
        return R.layout.activity_collect_money;
    }

    @Override
    public void initView() {
        editText = etCollectMoney;
        ivbtnCalcuatorDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editText.setText("");
                return false;
            }
        });
        etCollectMoney.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText = etCollectMoney;
                handler.sendEmptyMessage(EDIT_TYPE_CODE);
                return false;
            }
        });

        /**
         * 支付按钮
         */
        etCollectNotInvolvedMoney.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText = etCollectNotInvolvedMoney;
                handler.sendEmptyMessage(EDIT_TYPE_CODE);
                return false;
            }
        });
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public void closeKeyBord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

    /**
     * 支付按钮
     */
    private void startScan() {
        try {
            DecimalFormat df = new DecimalFormat("0.00");//该方法精度不会丢失
            String s = etCollectMoney.getText().toString();
            Double v = Double.parseDouble(s);
            String format = df.format(v);
            resultMoney = Double.valueOf(format);
            if (resultMoney < 0.01) {
                ToastUtils.shortToast("支付最低不能少于一分钱");
                return;
            }
        } catch (Exception e) {
            ToastUtils.shortToast("您输入的数字有误");
            return;
        }
        //运行时权限申请
        BaseActivity.requestRuntimePermission(permissions, new PermissionListener() {
            @Override
            public void onGranted() {
                startIntent();
            }

//            @Override
//            public void onDenied(List<String> deniedPermission) {
//                ToastUtils.shortToast("您已拒绝开启权限,请在手机设置-应用-当前应用-权限中重新设置");
//            }
        });
    }

    /**
     * 启动扫描判断是否是扫描枪,不是就启动android扫描
     */
    private void startIntent() {
        Intent intent = new Intent("com.summi.scan");
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, 0);
        boolean size = resolveInfos.size() > 0;
        if (size) {
            intent.setPackage("com.sunmi.sunmiqrcodescanner");
            startActivityForResult(intent, POS_CODE);
        } else {
            Intent intent1 = new Intent(this, CaptureActivity.class);
            startActivityForResult(intent1, CAMERA_CODE);
        }
    }


    @OnClick({R.id.iv_back, R.id.tv_sub_title, R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.ivbtn_calcuator_del, R.id.btn_four,
            R.id.btn_five, R.id.btn_six, R.id.ivbtn_calcuator_member, R.id.btn_seven, R.id.btn_eight, R.id.btn_nine,
            R.id.ivbtn_calcuator_weixin_alipay, R.id.btn_zero, R.id.btn_decimal_point, R.id.btn_plus, R.id.ivbtn_calculation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_sub_title:
                ToastUtils.shortToast("取消");
                break;
            case R.id.btn_one:
                addMoney("1");
                break;
            case R.id.btn_two:
                addMoney("2");
                break;
            case R.id.btn_three:
                addMoney("3");
                break;
            case R.id.ivbtn_calcuator_del:
                reduceMoney();
                break;
            case R.id.btn_four:
                addMoney("4");
                break;
            case R.id.btn_five:
                addMoney("5");
                break;
            case R.id.btn_six:
                addMoney("6");
                break;
            case R.id.ivbtn_calcuator_member:

                break;
            case R.id.btn_seven:
                addMoney("7");
                break;
            case R.id.btn_eight:
                addMoney("8");
                break;
            case R.id.btn_nine:
                addMoney("9");
                break;
            case R.id.ivbtn_calcuator_weixin_alipay:
                startScan();//扫码
                break;
            case R.id.btn_zero:
                addMoney("0");
                break;
            case R.id.btn_decimal_point:
                decimalPoint();
                break;
            case R.id.btn_plus:
                puls();
                break;
            case R.id.ivbtn_calculation:
                calculation();
                break;
        }
    }

    /**
     * 加数字，限制小数点后最多两位数字
     */
    private void addMoney(String num) {
        money = editText.getText().toString();
        money = AlgorithmUtils.getUpdate(money, num);
        editText.setText(money);
        additionOperation();
    }

    /**
     * 减数字
     */
    private void reduceMoney() {
        money = editText.getText().toString();
        if (money.length() > 0) {
            StringBuffer sb = new StringBuffer(money);
            sb.deleteCharAt(sb.length() - 1);
            editText.setText(sb);
            sb.setLength(0);
        }
        additionOperation();
    }

    /**
     * 计算第一个数字和第二个数字
     */
    private void additionOperation() {
        money = editText.getText().toString();
        int i = money.indexOf("+");
        if (i != -1) {
            n1 = money.substring(0, i);
            n2 = money.substring(i + 1, money.length());
        } else {
            n1 = money.substring(0, money.length());
            n2 = "";
        }
        editText.setSelection(money.length());
    }

    /**
     * 开始加法计算
     */
    private void calculation() {
        additionOperation();
        if (n1 == null || n2 == null) {
            ToastUtils.shortToast("请输入数字");
            return;
        }
        if (n1.length() == 0 || n2.length() == 0) {
            ToastUtils.shortToast("请输入数字");
            return;
        }
        try {
            String result = AlgorithmUtils.getResult(n1, n2);
            editText.setText(result);
            editText.setSelection(result.length());
        } catch (Exception e) {
            ToastUtils.shortToast("您输入的数字有误");
        }
    }

    /**
     * 输入符号 .
     */
    private void decimalPoint() {
        money = editText.getText().toString();
        if (money.length() == 0) {
            ToastUtils.shortToast("您输入的数字有误");
            return;
        }
        if (money.contains("+")) {
            if (!n2.contains(".")) {
                addMoney(".");
            }
        } else if (!n1.contains(".")) {
            addMoney(".");
        }
    }

    /**
     * 输入符号 +
     */
    private void puls() {
        money = editText.getText().toString();
        if (money.length() == 0) {
            ToastUtils.shortToast("您输入的数字有误");
            return;
        }
        if (!money.contains("+")) {
            addMoney("+");
        } else {
            calculation();
            money = editText.getText().toString();
            if (!money.contains("+")) {
                addMoney("+");
            }
        }
    }

    /**
     * 接收扫描结果返回
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        Bundle bundle = data.getExtras();

        switch (requestCode) {
            case POS_CODE:

                List<HashMap<String, String>> result = (ArrayList<HashMap<String, String>>) bundle.getSerializable("data");

                assert result != null;
                for (HashMap<String, String> hashMap : result) {
//                    Log.e("!!!!", hashMap.get("TYPE"));//这个是扫码的类型
//                    Log.e("!!!!", hashMap.get("VALUE"));//这个是扫码的结果
                    String scanno = hashMap.get("VALUE");
                    IntentUtils.toActivity(this, PosActivity.class, KeyConsts.SCAN_NO, scanno, KeyConsts.MONEY, resultMoney, KeyConsts.SUPPORT_PRINT, true);
                }
                break;
            case CAMERA_CODE:
                String scanno = bundle.getString("result");
                IntentUtils.toActivity(this, PosActivity.class, KeyConsts.SCAN_NO, scanno, KeyConsts.MONEY, resultMoney, KeyConsts.SUPPORT_PRINT, false);
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
