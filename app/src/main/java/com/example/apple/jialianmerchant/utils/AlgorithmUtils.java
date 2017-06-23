package com.example.apple.jialianmerchant.utils;

import java.text.DecimalFormat;

/**
 * 计算器简单算法
 */
public class AlgorithmUtils {
    /**
     * 计算两个值的和，转换小数点后两位
     */
    public static String getResult(String num1, String num2) {
        Float d1 = Float.parseFloat(num1);
        Float d2 = Float.parseFloat(num2);
        Float dd = d1 + d2;
        DecimalFormat df = new DecimalFormat("0.00");//该方法精度不会丢失
        String result = df.format(dd);
        int i = result.indexOf(".");

        if (i == -1) {
            return result;
        }

        String substring = result.substring(i + 1, result.length());//分离小数点后数字
        StringBuffer sb = new StringBuffer(substring);
        if (sb.length() > 2) {
            sb.setLength(2);
        }
        while (sb.length() > 0 && sb.lastIndexOf("0") == sb.length() - 1) {//小数点最后一位是否为0，为0就移除
            sb.setLength(sb.length() - 1);
        }

        if (sb.length() == 0) {//判断小数点后还有没有数字，没有就移除小数点
            result = result.substring(0, i);
        } else {
            result = result.substring(0, i + sb.length() + 1);
        }

        return result;
    }

    /**
     * 加数字,小数点后最多两位数
     */
    public static String getUpdate(String money, String num) {
        //没有小数点
        int indexOf = money.indexOf(".");
        if (indexOf == -1) {
            money = money + num;
            return money;
        }
        //有小数点，判断小数点后三位有无+，没有判断num是否为+，都不满足return
        if (money.length() == indexOf + 3 && !"+".equals(num) && !money.contains("+")) {
            return money;
        }
        //判断有无+号
        int indexOf2 = money.indexOf("+");
        if (indexOf2 == -1) {
            money = money + num;
            return money;
        }
        //判断+号后面有无小数点
        String substring = money.substring(indexOf2, money.length());
        int indexOf1 = substring.indexOf(".");
        if (indexOf1 == -1) {
            money = money + num;
            return money;
        }
        //+后面有小数点，判断第三位是否为+
        int j = substring.length() - indexOf1;
        if (j == 3 && !"+".equals(num)) {
            return money;
        }
        money = money + num;
        return money;
    }
}
