package com.example.apple.jialianmerchant.base;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.example.apple.jialianmerchant.listener.PermissionListener;
import com.example.apple.jialianmerchant.utils.ActivityCollector;
import com.example.apple.jialianmerchant.utils.LogUtil;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

    private static PermissionListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this, ActivityCollector.allActivity);
        setContentView(initLayout());
        LogUtil.e(this.getClass().getName() + "------onCreate");
        ButterKnife.bind(this);
        initView();
    }

    public abstract int initLayout();

    protected abstract void initView();


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    /**
     * 运行时申请权限的封装
     */
    public static void requestRuntimePermission(String[] permissions, PermissionListener listener) {
        Activity topActivity = ActivityCollector.getTopActivity();
        if (topActivity == null) {
            return;
        }

        mListener = listener;
        List<String> listPermission = new ArrayList<>();
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(topActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermission.add(permission);
            }
        }

        if (!listPermission.isEmpty()) {
            ActivityCompat.requestPermissions(topActivity, listPermission.toArray(new String[listPermission.size()]), 1);
        } else {
            listener.onGranted();
        }

    }

    /**
     * 运行时申请权限的回调封装
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    List<String> deniedPermission = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermission.add(permission);
                        }
                    }

                    if (deniedPermission.isEmpty()) {
                        mListener.onGranted();
                    } else {
                        //此处返回申请回调未授权的权限
//                        mListener.onDenied(deniedPermission);
                        ToastUtils.shortToast("您已拒绝开启权限,请在手机设置-应用-当前应用-权限中重新设置");
                    }
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeOne(this, ActivityCollector.allActivity);
        LogUtil.e(this.getClass().getName() + "------onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.e(this.getClass().getName() + "------onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.e(this.getClass().getName() + "------onStart");
    }

    /**
     * 非常重要：必须调用 MobclickAgent.onResume() 和MobclickAgent.onPause()方法，才能够保证获取正确的新增用户、活跃用户、启动次数、使用时长等基本数据。
     */
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        LogUtil.e(this.getClass().getName() + "------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
        LogUtil.e(this.getClass().getName() + "------onPause");
    }

    /**
     * -------------------------------------------------------
     */

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.e(this.getClass().getName() + "------onStop");
    }
}
