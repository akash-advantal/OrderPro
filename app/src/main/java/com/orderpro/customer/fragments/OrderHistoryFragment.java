package com.orderpro.customer.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.merchant.orderpro.R;
import com.orderpro.customer.DummyData;
import com.orderpro.customer.adapter.OrderHistoryAdapter;
import com.orderpro.customer.bean.OrderHistorydata;
import com.orderpro.customer.ui.CartItemActivity;
import com.orderpro.customer.ui.NavigationActivity;
import com.orderpro.customer.ui.OrderDetailsActivity;

import java.util.ArrayList;

/**
 * Created by AKASH on 23-Aug-16.
 */
public class OrderHistoryFragment extends Fragment implements View.OnClickListener {
    ListView order_listview;
    NavigationActivity navigationActivity;
    ArrayList<OrderHistorydata> orderlist;
    ImageView drawer_icon, cart;
    View view;
    DummyData ddobj = new DummyData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.orderhistory_lv, container, false);
        drawer_icon = (ImageView) view.findViewById(R.id.drawer_icon);
        cart = (ImageView) view.findViewById(R.id.cart);
        order_listview = (ListView) view.findViewById(R.id.lv_orderhistory);

        drawer_icon.setOnClickListener(this);
        cart.setOnClickListener(this);

        orderlist = ddobj.initOrderList();

        OrderHistoryAdapter md = new OrderHistoryAdapter(getActivity(), orderlist);

        order_listview.setAdapter(md);
        order_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), OrderDetailsActivity.class));
            }
        });
        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.drawer_icon:
                navigationActivity.toggle();

                break;
            case R.id.cart:
                startActivity(new Intent(getActivity(), CartItemActivity.class));
        }
    }






    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigationActivity = (NavigationActivity) getActivity();
    }

}