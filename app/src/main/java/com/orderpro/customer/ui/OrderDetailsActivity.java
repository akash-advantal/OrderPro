package com.orderpro.customer.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.merchant.orderpro.R;

/**
 * Created by AKASH on 23-Aug-16.
 */
public class OrderDetailsActivity extends Activity {
ImageView iv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_detail);
        iv_back =  (ImageView)  findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
