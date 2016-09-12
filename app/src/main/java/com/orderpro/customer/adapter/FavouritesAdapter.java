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
import com.orderpro.customer.bean.FavouritseListData;

import java.util.ArrayList;

/**
 * Created by AKASH on 04-Jun-16.
 */
public class FavouritesAdapter extends BaseAdapter {
    ArrayList<FavouritseListData> favouritselist;
    Context context;
    public FavouritesAdapter(Context context, ArrayList<FavouritseListData> favouritselist) {

        this.favouritselist = favouritselist;
        this.context = context;
    }

    @Override
        public int getCount() {
         return favouritselist.size();
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
        View v= lif.inflate(R.layout.your_favourites_item, null);

            ImageView item_image=(ImageView) v.findViewById(R.id.item_image);
           TextView item_title=(TextView) v.findViewById(R.id.item_title);
            TextView item_content=(TextView) v.findViewById(R.id.item_content);
            TextView item_decs=(TextView) v.findViewById(R.id.item_decs);


            FavouritseListData favouritseListData= favouritselist.get(position);
            item_title.setText(favouritseListData.getItem_title());
            item_content.setText(favouritseListData.getItem_content());
            item_decs.setText(favouritseListData.getItem_decs());

            item_image.setBackgroundResource(favouritseListData.getItem_image());


            return v;
    }


}