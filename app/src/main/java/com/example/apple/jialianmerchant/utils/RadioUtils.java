package com.example.apple.jialianmerchant.utils;

import android.widget.RadioButton;
import android.widget.RadioGroup;


public class RadioUtils {
    public static void setFristCheck(RadioGroup radioGroup) {
        RadioButton radioButton = (RadioButton) radioGroup.getChildAt(0);
        radioButton.setChecked(true);
    }
}
