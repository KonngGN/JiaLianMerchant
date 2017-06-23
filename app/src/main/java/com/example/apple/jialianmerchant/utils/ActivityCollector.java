package com.example.apple.jialianmerchant.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 作者：孔先生 on 2017/3/2 14:58
 * 邮箱：197726885@qq.com
 * 说明：保存Activity
 */
public class ActivityCollector {

    public static List<Activity> allActivity = new ArrayList<>();

    /**
     * 添加一个Activity到List中保存
     */
    public static void addActivity(Activity activity, List<Activity> list) {
        list.add(activity);
    }

    /**
     * 返回当前的Activity
     */
    public static Activity getTopActivity() {
        if (allActivity.isEmpty()) {
            return null;
        }

        return allActivity.get(allActivity.size() - 1);
    }

    /**
     * 移除List中保存的单个添加一个Activity到List中保存,遍历同时remove用这种写法
     */
    public static void removeOne(Activity activity, List<Activity> list) {

        for (Iterator<Activity> iterator = list.iterator(); iterator.hasNext(); ) {
            if (iterator.next().equals(activity)) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
                iterator.remove();
            }
        }
    }


    /**
     * 移除List中保存的所有添加一个Activity到List中保存
     */
    public static void finishALL(List<Activity> list) {
        for (Activity activity : list) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
