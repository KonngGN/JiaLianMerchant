package com.example.apple.jialianmerchant.adapter;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.apple.jialianmerchant.R;
import com.example.apple.jialianmerchant.bean.response.ListShopBean;
import com.example.apple.jialianmerchant.ui.StoreDetailsActivity;
import com.example.apple.jialianmerchant.utils.IntentUtils;

import java.util.List;

public class MyStoreAdapter extends BaseAbstractAdapter<ListShopBean.MMListBean> {


    public MyStoreAdapter(Context context, List<ListShopBean.MMListBean> list) {
        super(context, list, R.layout.item_list_my_stroe);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        ListShopBean.MMListBean mmListBeen = list.get(position);
        View view = holder.getView(R.id.rl_to_store_details);
        TextView storeName = holder.getView(R.id.tv_store_name);
        TextView storeID = holder.getView(R.id.tv_store_id);
        TextView shopName = holder.getView(R.id.tv_shopowner_name);
        TextView shopPhone = holder.getView(R.id.tv_shopowner_phone);
        storeName.setText(mmListBeen.getShopName());
        storeID.setText(mmListBeen.getShopID() + "");
        shopName.setText(mmListBeen.getShopOwnerName());
        shopPhone.setText(mmListBeen.getShopOwnerTel());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.toActivity(context, StoreDetailsActivity.class);
            }
        });
    }
}
