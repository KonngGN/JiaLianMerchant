package com.example.apple.jialianmerchant.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;


public class PhoneDialogUtils {


    private static AlertDialog dialog;
    public static AlertDialog getPhoneDialog(final Context context, String title, final String phone) {
        dialog = new AlertDialog.Builder(context).create();
        dialog.show();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.getWindow().setContentView(R.layout.dialog_phone);
        dialog.getWindow().setBackgroundDrawableResource(R.color.alphaAll);
        dialog.setCanceledOnTouchOutside(false);
        TextView btnUpdateNow = (TextView) dialog.getWindow().findViewById(R.id.btn_sure);
        TextView btnUpdateAfter = (TextView) dialog.getWindow().findViewById(R.id.btn_cancel);
        TextView tvPhone = (TextView) dialog.getWindow().findViewById(R.id.tv_kefu_phone);
        TextView tvTitle = (TextView) dialog.getWindow().findViewById(R.id.tv_alertdialog_title);
        tvTitle.setText(title);
        tvPhone.setText(phone);
        btnUpdateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确定
//                dialogClick.confimBtn(phone);
                dialog.cancel();
                IntentUtils.phoneDialogUtils(context, phone);
            }
        });
        btnUpdateAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取消
                dialog.cancel();
            }
        });
        return dialog;
    }


}
