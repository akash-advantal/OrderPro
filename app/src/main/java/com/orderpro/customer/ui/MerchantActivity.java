package com.orderpro.customer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.merchant.orderpro.R;
import com.orderpro.customer.DummyData;
import com.orderpro.customer.adapter.MerchantAdapter;
import com.orderpro.customer.bean.MerchantListData;

import java.util.ArrayList;

/**
 * Created by AKASH on 23-Aug-16.
 */
public class MerchantActivity extends AppCompatActivity implements View.OnClickListener {
    ListView merchant_listview;
    ArrayList<MerchantListData> merchantList;
    ImageView drawer_icon, cart;

    TextView title;
    DummyData ddobj = new DummyData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymerchant_lv);
        drawer_icon = (ImageView) findViewById(R.id.drawer_icon);
        merchant_listview = (ListView) findViewById(R.id.lv_mymerchant);
        cart = (ImageView) findViewById(R.id.cart);
        cart.setVisibility(View.GONE);
        title = (TextView) findViewById(R.id.title);
        drawer_icon.setOnClickListener(this);
        drawer_icon.setBackground(getResources().getDrawable(R.drawable.back_arrows_white));
        title.setText("Your Merchsnt List");
        merchantList = ddobj.initmerchantList();
        MerchantAdapter md = new MerchantAdapter(MerchantActivity.this, merchantList);

        merchant_listview.setAdapter(md);


        merchant_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.e("kjdhszdbvs", (Integer.toString(position)));
                Intent in = new Intent(MerchantActivity.this, MerchantDetailsActivity.class);
                startActivity(in);
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
//
}
