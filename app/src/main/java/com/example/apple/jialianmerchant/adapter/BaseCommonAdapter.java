package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apple.jialianmerchant.listener.MyClickListener;
import com.example.apple.jialianmerchant.utils.LogUtil;

import java.util.List;

/**
 * 作者：孔先生 on 2017/3/3 17:10
 * 邮箱：197726885@qq.com
 * 说明：
 */
public abstract class BaseCommonAdapter<T> extends RecyclerView.Adapter<RvViewHolder>  {
    protected Context context;
    protected int mLayoutId;
    protected List<T> list;
    protected LayoutInflater mInflater;
    protected MyClickListener myClickListener;
    protected View mView;

    public BaseCommonAdapter(Context context, int layoutId, List<T> list) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        this.list = list;
    }

    /**
     * item点击事件回调
     *
     * @param myClickListener 我的点击接口
     */
    public void setItemClick(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public RvViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
//        RvViewHolder viewHolder = RvViewHolder.get(context, parent, mLayoutId);
        View itemView = LayoutInflater.from(context).inflate(mLayoutId, parent,
                false);
        mView = itemView;
        return new RvViewHolder(context, itemView, parent);
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position) {
        convert(holder, list.get(position), position);
    }

    public abstract void convert(RvViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return list.size();
    }

}
