package com.example.apple.jialianmerchant.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 作者：孔先生 on 2017/2/25 15:01
 * 邮箱：197726885@qq.com
 * 说明：搜索数据库
 */
public class RecordSQLiteOpenHelper extends SQLiteOpenHelper {
    private static int version = 1;

    public RecordSQLiteOpenHelper(Context context) {
        super(context, "temp.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table records(id integer primary key autoincrement,name varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
