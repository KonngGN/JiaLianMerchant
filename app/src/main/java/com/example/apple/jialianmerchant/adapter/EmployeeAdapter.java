package com.example.apple.jialianmerchant.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.response.ListEmployeeBean;

import java.util.List;


public class EmployeeAdapter extends BaseAbstractAdapter<ListEmployeeBean.MMListBean>{
    public EmployeeAdapter(Context context, List<ListEmployeeBean.MMListBean> list) {
        super(context, list, R.layout.item_list_employee);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        TextView id = holder.getView(R.id.tv_employee_id);
        TextView name = holder.getView(R.id.tv_employee_name);
        TextView tel = holder.getView(R.id.tv_employee_tel);

        id.setText(list.get(position).getEmployeeID()+"");
        name.setText(list.get(position).getEmployeeName()+"");
        tel.setText(list.get(position).getEmployeeTel()+"");
    }
}
