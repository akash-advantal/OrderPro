package com.orderpro.customer.adapter;
/**
 * Created by AKASH on 29-Aug-16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.merchant.orderpro.R;
import com.orderpro.customer.bean.NotificationData;

import java.util.ArrayList;

/**
 * Created by AKASH on 04-Jun-16.
 */
public class NotificationAdapter extends BaseAdapter {
    ArrayList<NotificationData> notificationlist;
    Context context;
    public NotificationAdapter(Context context, ArrayList<NotificationData> notificationlist) {

        this.notificationlist = notificationlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return notificationlist.size();
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
        View v= lif.inflate(R.layout.notification, null);
//
//        ImageView item_image=(ImageView) v.findViewById(R.id.item_image);
//        TextView item_title=(TextView) v.findViewById(R.id.merchant_name);
//        TextView item_content=(TextView) v.findViewById(R.id.item_content);
//        TextView item_decs=(TextView) v.findViewById(R.id.merchant_address);
//
//
//        NotificationData notificationData= notificationlist.get(position);
//        item_title.setText(notificationData.getItem_title());
//        item_content.setText(notificationData.getItem_content());
//        item_decs.setText(notificationData.getItem_decs());
//
//        item_image.setBackgroundResource(notificationData.getItem_image());
//

        return v;
    }


}