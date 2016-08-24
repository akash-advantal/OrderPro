package com.orderpro.customer.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.merchant.orderpro.R;

/**
 * Created by AKASH on 23-Aug-16.
 */
public class OrderHistoryActivity extends Activity {
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.your_orders_item);
        iv = (ImageView)   findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderHistoryActivity.this,OrderDetailsActivity.class));

            }
        });

    }
}
