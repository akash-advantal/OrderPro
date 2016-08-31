package com.orderpro.customer.fragments;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.merchant.orderpro.R;
import com.orderpro.customer.adapter.OrderHistoryAdapter;
import com.orderpro.customer.bean.OrderHistorydata;
import com.orderpro.customer.ui.NavigationActivity;

import java.util.ArrayList;

/**
 * Created by AKASH on 23-Aug-16.
 */
public class OrderHistoryFragment extends Fragment implements View.OnClickListener {
    ListView order_listview;
    NavigationActivity navigationActivity;
    ArrayList<OrderHistorydata> orderlist;


    Button drawer_icon;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.orderhistory_lv, container, false);
        drawer_icon = (Button) view.findViewById(R.id.drawer_icon);
        order_listview = (ListView) view.findViewById(R.id.lv_orderhistory);
        drawer_icon.setOnClickListener(this);

        orderlist = new ArrayList<OrderHistorydata>();
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        OrderHistoryAdapter md = new OrderHistoryAdapter(getActivity(), orderlist);
        order_listview.setAdapter(md);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigationActivity = (NavigationActivity) getActivity();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.drawer_icon:
                navigationActivity.toggle();

                break;
        }
    }





}