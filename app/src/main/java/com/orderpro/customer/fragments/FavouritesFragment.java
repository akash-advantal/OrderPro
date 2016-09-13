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
import android.widget.TextView;

import com.merchant.orderpro.R;
import com.orderpro.customer.DummyData;
import com.orderpro.customer.adapter.FavouritesAdapter;
import com.orderpro.customer.bean.FavouritseListData;
import com.orderpro.customer.ui.CartItemActivity;
import com.orderpro.customer.ui.NavigationActivity;
import com.orderpro.customer.ui.OrderDetailsActivity;

import java.util.ArrayList;

/**
 * Created by AKASH on 23-Aug-16.
 */
public class FavouritesFragment extends Fragment implements View.OnClickListener {
    ListView favourites_listview;
    NavigationActivity navigationActivity;
    ArrayList<FavouritseListData> favouritselist;
    ImageView drawer_icon, cart;
    View view;
    TextView title;
    DummyData ddobj = new DummyData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.orderhistory_lv, container, false);
        drawer_icon = (ImageView) view.findViewById(R.id.drawer_icon);
        cart = (ImageView) view.findViewById(R.id.cart);
        favourites_listview = (ListView) view.findViewById(R.id.lv_orderhistory);
        title = (TextView) view.findViewById(R.id.title);
        title.setText("My Favourites");
        drawer_icon.setOnClickListener(this);
        cart.setOnClickListener(this);

        favouritselist = ddobj.initFavouritesData();

        FavouritesAdapter md = new FavouritesAdapter(getActivity(), favouritselist);

        favourites_listview.setAdapter(md);
        favourites_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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