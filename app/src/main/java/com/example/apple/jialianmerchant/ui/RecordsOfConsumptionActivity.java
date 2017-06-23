package com.example.apple.jialianmerchant.ui;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.adapter.ChangedOutAdapter;
import com.example.apple.jialianmerchant.base.BaseActivity;
import com.example.apple.jialianmerchant.base.BaseApp;
import com.example.apple.jialianmerchant.bean.request.ChangeDoutListRequest;
import com.example.apple.jialianmerchant.bean.response.ChangeDoutListBean;
import com.example.apple.jialianmerchant.constant.OperatorConsts;
import com.example.apple.jialianmerchant.db.RecordSQLiteOpenHelper;
import com.example.apple.jialianmerchant.utils.IntentUtils;
import com.example.apple.jialianmerchant.utils.ProgressDialogUtils;
import com.example.apple.jialianmerchant.utils.ToastUtils;
import com.example.apple.jialianmerchant.utils.http.BeanCallback;
import com.example.apple.jialianmerchant.utils.http.HttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：孔先生 on
 * 邮箱：197726885@qq.com
 * 说明：消费记录
 */
public class RecordsOfConsumptionActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ls_record)
    PullToRefreshListView lsRecord;
    @BindView(R.id.ls_search)
    ListView lsSearch;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_search_view)
    LinearLayout llSearchView;

    private List<ChangeDoutListBean.ChangedListBean> list;
    private ChangedOutAdapter adapter;
    private RecordSQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private SearchView searchView;
    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.activity_recordsofconsumption;
    }

    @Override
    public void initView() {
        progressDialog = ProgressDialogUtils.getLoadingDataDialog(this);
        list = new ArrayList<>();
        tvTitle.setText(R.string.Member_consumption);
        toolbar.setTitle("");//toobar标题要为空
        setSupportActionBar(toolbar);
        getRecords();
        adapter = new ChangedOutAdapter(this, list);
        lsRecord.setAdapter(adapter);
    }

    @OnClick({R.id.rl_search_view, R.id.tv_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_search_view:
                IntentUtils.toActivity(this, SearchActivity.class);
                break;
            case R.id.tv_clear:
                deleteData();
                break;
        }
    }

    /**
     * 请求网络
     */
    private void getRecords() {
        progressDialog.show();
        HttpUtils.post(OperatorConsts.VIP_CHANGEDOUTLIST, new ChangeDoutListRequest(1, 1, 1, 0, "", "2016-11-11", "2017-03-01"), new BeanCallback<ChangeDoutListBean>() {
            @Override
            public void onResponse(ChangeDoutListBean response, int id) {
                int success = response.getSuccess();
                if (success == 1) {
                    tvTotalMoney.setText(String.valueOf(response.getTotalMoney()));
                    list.addAll(response.getChangedList());
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.shortToast(response.getMsg());
                }
                progressDialog.dismiss();

            }
        });
    }

    /**
     * 添加搜索菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);

        // Retrieve the SearchView and plug it into SearchManager
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
                lsSearch.setTextFilterEnabled(true);//Listview设置过滤
                lsSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    //listview点击事件
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView s = (TextView) view.findViewById(android.R.id.text1);
                        CharSequence text = s.getText();
                        searchView.setQuery(text,true);
                    }
                });
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
                            llSearchView.setVisibility(View.VISIBLE);
                            queryData(newText);
                        } else {
                            llSearchView.setVisibility(View.GONE);
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
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"name"},
                new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        // 设置适配器
        lsSearch.setAdapter(cursorAdapter);
        cursorAdapter.notifyDataSetChanged();
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
        queryData("");
    }
}
