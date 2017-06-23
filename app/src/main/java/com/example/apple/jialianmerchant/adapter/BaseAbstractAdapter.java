package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class BaseAbstractAdapter<T> extends BaseAdapter {
    protected LayoutInflater inflater;
    protected Context context;
    protected List<T> list;
    private int layout_id;

    public BaseAbstractAdapter(Context context, List<T> list, int layout_id) {
        this.context = context;
        this.list = list;
        this.layout_id = layout_id;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 初始化ViewHolder,使用通用的ViewHolder，一样代码就搞定ViewHolder的初始化
        ViewHolder holder = ViewHolder.get(context, convertView, parent,layout_id, position);
        convert(holder,position);
        return holder.getmConvertView();
    }

    public abstract void convert(ViewHolder holder, int position);



}
