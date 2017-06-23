package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.bean.request.UserRequest;
import com.example.apple.jialianmerchant.bean.response.LoginBean;
import com.example.apple.jialianmerchant.constant.KeyConsts;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.utils.ActivityCollector;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.SharedPreferencesUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录页面,
 *      进入页面清空sooID,sooTimeSign,登录状态
 *      登录成功保存sooID,sooTimeSign
 *
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_user_num)
    AutoCompleteTextView etUserNum;
//    @BindView(R.id.iv_del_num)
//    ImageView ivDelNum;
    @BindView(R.id.et_user_psw)
    EditText etUserPsw;
//    @BindView(R.id.iv_del_psw)
//    ImageView ivDelPsw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private ProgressDialog loadingDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        loadingDialog = ProgressDialogUtils.getLoadingDialog(this, "正在登录...");
        SharedPreferencesUtils.saveLoginMessage("", "", false);
        String username = SharedPreferencesUtils.getLoginMessage().getString(KeyConsts.USER_NAME, "");
        String password = SharedPreferencesUtils.getLoginMessage().getString(KeyConsts.PASS_WORD, "");
        etUserNum.setText(username);
        etUserPsw.setText(password);
    }

    @OnClick({ R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.iv_del_num:
//                etUserNum.setText("");
//                break;
//            case R.id.iv_del_psw:
//                etUserPsw.setText("");
//                break;
            case R.id.btn_login:
                login();
                break;
        }
    }

    /**
     * 获取登录信息
     */
    private void login() {
        loadingDialog.show();
        final String userNum = etUserNum.getText().toString().trim();
        final String userPsw = etUserPsw.getText().toString().trim();
        HttpUtils.post(OperatorConsts.USER_LOGIN, new UserRequest(userNum, userPsw), new BeanCallback<LoginBean>() {
                    @Override
                    public void onResponse(LoginBean response, int id) {
                        int success = response.getSuccess();
                        String sooID = response.getSooID();
                        String sooTimeSign = response.getSooTimeSign();
                        String msg = response.getMsg();
                        if (success == 1) {
                            SharedPreferencesUtils.saveLoginMessage(userNum, userPsw, sooID, sooTimeSign, true);
                            LoginActivity.this.finish();
                        } else {
                            LoginActivity.this.finish();
                            ToastUtils.shortToast(msg);
                        }
                        loadingDialog.dismiss();
                    }
                }
        );
    }
    /**
     * destroy时判断dialog是否取消
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    /**
     * 连续后退两次退出程序
     */
    // 设置第一次按的时间
    long currentMillions = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 第一次的时间
            if (System.currentTimeMillis() - currentMillions > 2000) {
                ToastUtils.shortToast("请再按一次退出");
                // 获取第二次点击的时间 然后判断两次时间差
                currentMillions = System.currentTimeMillis();
            } else {
                ActivityCollector.finishALL(ActivityCollector.allActivity);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
