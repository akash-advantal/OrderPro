package com.orderpro.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.merchant.orderpro.R;
import com.orderpro.customer.bean.MerchantListData;

import java.util.ArrayList;

/**
 * Created by AKASH on 09-Sep-16.
 */
public class MerchantAdapter extends BaseAdapter {
       ArrayList<MerchantListData> merchantList;
        Context context;
    MerchantListData merchantListData;

    public MerchantAdapter(Context context, ArrayList<MerchantListData> merchantList) {
        this.merchantList = merchantList;
        this.context = context;


    }



    @Override
    public int getCount() {
        return merchantList.size();
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
            View v= lif.inflate(R.layout.merchant_list_items, null);
           TextView merchant_name=(TextView) v.findViewById(R.id.merchant_name);

            TextView merchant_no=(TextView) v.findViewById(R.id.merchant_no);
            TextView merchant_address=(TextView) v.findViewById(R.id.merchant_address);
//            merchantListData= merchantListData.get(position);

            merchantListData = merchantList.get(position);

            merchant_name.setText(merchantListData.getMerchant_name());
            merchant_no.setText(merchantListData.getMerchant_no());
            merchant_address.setText(merchantListData.getMerchant_adress());

            return v;
        }


    }