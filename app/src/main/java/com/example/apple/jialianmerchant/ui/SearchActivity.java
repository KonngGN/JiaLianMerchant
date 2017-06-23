package com.example.apple.jialianmerchant.ui;

import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.base.BaseActivity;

import butterknife.BindView;

public class SearchActivity extends BaseActivity {

    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};
    @BindView(R.id.sv_search)
    SearchView svSearch;
    @BindView(R.id.listView)
    ListView listView;

    @Override
    public int initLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStrs);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
        svSearch.setSubmitButtonEnabled(true);

        // 设置搜索文本监听
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    adapter.getFilter().filter(newText);
                } else {
                    adapter.getFilter().filter("");
                }
                return false;
            }
        });
    }


}
