package com.orderpro.customer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.merchant.orderpro.R;
import com.orderpro.customer.adapter.CartItemAdapter;
import com.orderpro.customer.bean.OrderHistorydata;

import java.util.ArrayList;

/**
 * Created by AKASH on 23-Aug-16.
 */
public class CartItem extends AppCompatActivity implements View.OnClickListener {
    ListView cart_listview;
    ArrayList<OrderHistorydata> cartlist;
    ImageView drawer_icon, cart;
    View view;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderhistory_lv);
        drawer_icon = (ImageView) findViewById(R.id.drawer_icon);
        cart_listview = (ListView) findViewById(R.id.lv_orderhistory);
        cart = (ImageView) findViewById(R.id.cart);
        cart.setVisibility(View.GONE);
        title = (TextView) findViewById(R.id.title);
        drawer_icon.setOnClickListener(this);
        drawer_icon.setBackground(getResources().getDrawable(R.drawable.arrow_back));
        title.setText("Your Cart Items");
        cartlist = new ArrayList<OrderHistorydata>();
        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));

        CartItemAdapter md = new CartItemAdapter(CartItem.this, cartlist);

        cart_listview.setAdapter(md);
        cart_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(CartItem.this, OrderDetailsActivity.class));
                Toast.makeText(CartItem.this, "0", Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.drawer_icon:
                finish();
                break;
        }
    }


//    public void OrderHistory(ArrayList<OrderHistorydata> orderlist) {
//        this.orderlist = orderlist;
//    }
}
