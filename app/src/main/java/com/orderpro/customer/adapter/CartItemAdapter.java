package com.orderpro.customer.adapter;
/**
 * Created by AKASH on 29-Aug-16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.orderpro.R;
import com.orderpro.customer.bean.OrderHistorydata;

import java.util.ArrayList;

/**
 * Created by AKASH on 04-Jun-16.
 */
public class CartItemAdapter extends BaseAdapter {
    ArrayList<OrderHistorydata> orderlist;
    Context context;
    public CartItemAdapter(Context context, ArrayList<OrderHistorydata> orderlist) {

        this.orderlist = orderlist;
        this.context = context;
    }

    @Override
        public int getCount() {
         return orderlist.size();
    }

        @Override
        public Object getItem(int position) {
         return position;
    }

        @Override
        public long getItemId(int position) {
         return 0;
    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater lif= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= lif.inflate(R.layout.your_orders_item, null);

            ImageView item_image=(ImageView) v.findViewById(R.id.item_image);
           TextView item_title=(TextView) v.findViewById(R.id.item_title);
            TextView item_content=(TextView) v.findViewById(R.id.item_content);
            TextView item_decs=(TextView) v.findViewById(R.id.item_decs);


            OrderHistorydata orderHistorydata= orderlist.get(position);
            item_title.setText(orderHistorydata.getItem_title());
            item_content.setText(orderHistorydata.getItem_content());
            item_decs.setText(orderHistorydata.getItem_decs());

            item_image.setBackgroundResource(orderHistorydata.getItem_image());


            return v;
    }


}