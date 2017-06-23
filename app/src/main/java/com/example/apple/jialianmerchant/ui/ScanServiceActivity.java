package com.example.apple.jialianmerchant.ui;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.base.BaseApp;
import com.example.apple.jialianmerchant.db.RecordSQLiteOpenHelper;
import com.example.apple.jialianmerchant.utils.ToastUtils;

import butterknife.BindView;

public class ScanServiceActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ls_record)
    ListView lsRecord;
    private RecordSQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private SimpleCursorAdapter adapter;
    private SearchView searchView;

    @Override
    public int initLayout() {
        return R.layout.activity_scan_service;
    }

    @Override
    public void initView() {
        tvTitle.setText("扫一扫核销");
        toolbar.setTitle("");//toobar标题要为空
        setSupportActionBar(toolbar);
    }

    /**
     * 添加搜索菜单
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        searchView = (SearchView) MenuItemCompat
                .getActionView(menu.findItem(R.id.action_search));

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;

    }

    /**
     * toobar点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ToastUtils.shortToast(item.getTitle() + "");
        switch (item.getItemId()) {
            case R.id.action_search://搜索按钮

                helper = new RecordSQLiteOpenHelper(BaseApp.getContext());
                lsRecord.setTextFilterEnabled(true);//Listview设置过滤
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    // 当点击搜索按钮时触发该方法
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        if (!TextUtils.isEmpty(query) && !hasData(query)) {
                            insertData(query);
                        }
                        return false;
                    }

                    // 当搜索内容改变时触发该方法
                    @Override
                    public boolean onQueryTextChange(String newText) {
                        if (!TextUtils.isEmpty(newText)) {
                            lsRecord.setVisibility(View.VISIBLE);
                            queryData(newText);
                        } else {
                            lsRecord.setVisibility(View.GONE);
                        }
                        return false;
                    }
                });
                break;
        }
        return true;

    }

    /**
     * 插入数据
     */
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    /**
     * 模糊查询数据
     */
    private void queryData(String tempName) {
         Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
        // 创建adapter适配器对象
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"name"},
                new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        // 设置适配器
        lsRecord.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * 检查数据库中是否已经有该条记录
     */
    private boolean hasData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{tempName});
        //判断是否有下一个
        return cursor.moveToNext();
    }

    /**
     * 清空数据
     */
    private void deleteData() {
        db = helper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
    }
}

