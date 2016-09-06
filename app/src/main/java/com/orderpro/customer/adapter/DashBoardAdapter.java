package com.orderpro.customer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.orderpro.R;
import com.orderpro.customer.bean.ItemDataDashBoardList;

import java.util.ArrayList;


public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.ViewHolder> {
    private ArrayList<ItemDataDashBoardList> itemsData;
    Context contexts;

    public DashBoardAdapter(Context contexts, ArrayList<ItemDataDashBoardList> itemsData) {
        this.itemsData = itemsData;
        this.contexts = contexts;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DashBoardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_listview, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewTitle.setText(itemsData.get(position).getTitle());
        viewHolder.imgViewIcon.setImageDrawable(contexts.getResources().getDrawable(itemsData.get(position).getImageUrl()));
        Log.e("@@@", String.valueOf(viewHolder.getAdapterPosition()));
//        itemsData[position].getTitle();
//        viewHolder.txtViewTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(contexts, "jsdgvkuydhvlds", Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }

    // inner class to hold a reference to each item of RecyclerView 
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);

        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return itemsData.size();

    }

}