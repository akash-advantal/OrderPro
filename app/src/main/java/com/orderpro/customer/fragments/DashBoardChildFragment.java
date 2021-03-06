package com.orderpro.customer.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.merchant.orderpro.R;
import com.orderpro.customer.DummyData;
import com.orderpro.customer.adapter.DashBoardAdapter;
import com.orderpro.customer.ui.ProductActivity;
import com.orderpro.customer.util.RecyclerItemClickListener;

/**
 * Created by AKASH on 30-Aug-16.
 */
public class DashBoardChildFragment extends Fragment implements View.OnClickListener {

    public RecyclerView mRecyclerView;
    public LinearLayout insertlayout;
    public HorizontalScrollView horizontalscroll;
    public DummyData ddobj = new DummyData();
    public TextView tv_a, tv_b, tv_c, tv_d, tv_e;
    public ImageView iv_a, iv_b, iv_c, iv_d;
    public DashBoardAdapter mAdapter;
    //    TextView tv_f;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.Recyclerview);
        insertlayout = (LinearLayout) v.findViewById(R.id.insertlayout);
        horizontalscroll = (HorizontalScrollView) v.findViewById(R.id.horizontalscroll);

//       insertTextView("Electronics");
        ddobj.initParentData();
        tv_a = (TextView) v.findViewById(R.id.tv_a);
        tv_b = (TextView) v.findViewById(R.id.tv_b);
        tv_c = (TextView) v.findViewById(R.id.tv_c);
        tv_d = (TextView) v.findViewById(R.id.tv_d);
        tv_e = (TextView) v.findViewById(R.id.tv_e);

        tv_a.setOnClickListener(this);
        tv_b.setOnClickListener(this);
        tv_c.setOnClickListener(this);
        tv_d.setOnClickListener(this);
        tv_e.setOnClickListener(this);
//        tv_f.setOnClickListener(this);

        iv_a = (ImageView) v.findViewById(R.id.iv_a);
        iv_b = (ImageView) v.findViewById(R.id.iv_b);
        iv_c = (ImageView) v.findViewById(R.id.iv_c);
        iv_d = (ImageView) v.findViewById(R.id.iv_d);

        // this is data fro recycler view
        // 2. set layoutManger
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 3. create an adapter
        mAdapter = new DashBoardAdapter(getActivity(), ddobj.itemData);
        // 4. set adapter
        mRecyclerView.setAdapter(mAdapter);

        // 5. set item animator to DefaultAnimator
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                     /*   list_title.setVisibility(View.VISIBLE);
                        list_title.setText(itemsData[position].getTitle());*/
                        insertTextView(ddobj.itemData.get(position).getTitle());//passing title tofunction
                        //to find   item position@AKASH
                        Log.e("@@@@@", "" + position + ddobj.itemData.get(position).getTitle());

                    }
                })
        );

        return v;
    }

    public void insertTextView(String value) {
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
        //  tv.setBackgroundResource(R.drawable.button_rounded);
//        horizontalscroll.setVisibility(View.VISIBLE);
        horizontalscroll.setVisibility(View.VISIBLE);

        if (value.equals("Mobiles")) {
            horizontalscroll.setVisibility(View.VISIBLE);
            horizontalscroll.fullScroll(HorizontalScrollView.FOCUS_LEFT);

            tv_a.setVisibility(View.VISIBLE);
            iv_a.setVisibility(View.VISIBLE);

            tv_a.setText(value);
            ddobj.initMobileData();
            mAdapter.notifyDataSetChanged();

//            tv = new TextView(getActivity());
//            tv.setLayoutParams(params);
//            tv.setTextColor(Color.WHITE);
//            tv.setTextSize(15);
//            tv.setGravity(Gravity.CENTER | Gravity.BOTTOM);
//            tv.setText("  " + value + " > ");
//            insertlayout.addView(tv);
//            insertlayout.setVisibility(View.VISIBLE);
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Toast.makeText(getActivity(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
//               //     Toast.makeText(getActivity(), ((TextView) tv1).getText().toString(),Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getActivity(), ((TextView) tv).getText().toString(),Toast.LENGTH_SHORT).show();
//                }
//            });
//            tv1 = new TextView(getActivity());
//            tv1.setLayoutParams(params);
//            tv1.setTextColor(Color.WHITE);
//            tv1.setTextSize(15);
//            tv1.setText("  " + value + " > ");
//            insertlayout.addView(tv1);

        } else if (value.equals("Accessories")) {

            Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();

        } else if (value.equals("Samsung")) {

            tv_b.setVisibility(View.VISIBLE);
            iv_b.setVisibility(View.VISIBLE);
            tv_b.setText(value);
            ddobj.initMoblieSubCategoryOneData();
            mAdapter.notifyDataSetChanged();

        } else if (value.equals("SmartPhone")) {
            tv_c.setVisibility(View.VISIBLE);
            iv_c.setVisibility(View.VISIBLE);
            tv_c.setText(value);
            ddobj.initMoblieSubCategoryTwoData();
            mAdapter.notifyDataSetChanged();
        } else if (value.equals("S series")) {
            tv_d.setVisibility(View.VISIBLE);
            iv_d.setVisibility(View.VISIBLE);
            tv_d.setText(value);
            // horizontalscroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT);

            ddobj.initMoblieSubCategoryThreeData();
            mAdapter.notifyDataSetChanged();
        } else if (value.equals("Samsung S1")) {
            tv_e.setText(value);
            tv_e.setVisibility(View.VISIBLE);
            //horizontalscroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            ddobj.initChildData();
            mAdapter.notifyDataSetChanged();

            horizontalscroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT);


        } else if (value.equals("a")) {

            startActivity(new Intent(getActivity(), ProductActivity.class));
        } else if (value.equals("Appliances")) {
            ddobj.initAppliancesData();
            mAdapter.notifyDataSetChanged();

        } else if (value.equals("Electronics")) {
            ddobj.initParentData();
            mAdapter.notifyDataSetChanged();

        } else if (value.equals("Home Entertainment")) {
            tv_a.setText(value);
            tv_a.setVisibility(View.VISIBLE);
            horizontalscroll.setVisibility(View.VISIBLE);

            ddobj.initChildData();
            mAdapter.notifyDataSetChanged();

        } else {
//            Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
            horizontalscroll.setVisibility(View.GONE);

            ddobj.initParentData();
            mAdapter.notifyDataSetChanged();

        }
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.tv_a:

                insertTextView(tv_a.getText().toString());

                // Toast.makeText(getActivity(), tv_a.getText().toString(), Toast.LENGTH_SHORT).show();
//                if (tv_a.getText().toString().equals("Mobiles")) {
//                    Toast.makeText(getActivity(), tv_a.getText().toString(), Toast.LENGTH_SHORT).show();
//                    tv_a.setText("Mobiles");
//                    ddobj.initMobileData();
//                    mAdapter.notifyDataSetChanged();

                tv_b.setVisibility(View.INVISIBLE);
                tv_c.setVisibility(View.INVISIBLE);
                tv_d.setVisibility(View.INVISIBLE);
                tv_e.setVisibility(View.INVISIBLE);
                iv_b.setVisibility(View.INVISIBLE);
                iv_c.setVisibility(View.INVISIBLE);
                iv_d.setVisibility(View.INVISIBLE);

                break;

            case R.id.tv_b:
//                Toast.makeText(getActivity(), tv_b.getText().toString(), Toast.LENGTH_SHORT).show();
                insertTextView(tv_b.getText().toString());

                tv_c.setVisibility(View.INVISIBLE);
                tv_d.setVisibility(View.INVISIBLE);
                tv_e.setVisibility(View.INVISIBLE);
                iv_c.setVisibility(View.INVISIBLE);
                iv_d.setVisibility(View.INVISIBLE);
                break;

            case R.id.tv_c:
//                Toast.makeText(getActivity(), tv_c.getText().toString(), Toast.LENGTH_SHORT).show();
                insertTextView(tv_c.getText().toString());
                tv_d.setVisibility(View.INVISIBLE);
                tv_e.setVisibility(View.INVISIBLE);
                iv_d.setVisibility(View.INVISIBLE);
                break;

            case R.id.tv_d:
                //  Toast.makeText(getActivity(), tv_d.getText().toString(), Toast.LENGTH_SHORT).show();
                insertTextView(tv_d.getText().toString());
                tv_e.setVisibility(View.INVISIBLE);

                break;
            case R.id.tv_e:
//                Toast.makeText(getActivity(), tv_e.getText().toString(), Toast.LENGTH_SHORT).show();
                insertTextView(tv_e.getText().toString());

                break;

        }

    }

    public void hideTitleBar() {

//        horizontalscroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        horizontalscroll.setVisibility(View.GONE);
        tv_a.setVisibility(View.INVISIBLE);
        iv_a.setVisibility(View.INVISIBLE);
        tv_b.setVisibility(View.INVISIBLE);
        iv_b.setVisibility(View.INVISIBLE);
        tv_c.setVisibility(View.INVISIBLE);
        iv_c.setVisibility(View.INVISIBLE);
        tv_d.setVisibility(View.INVISIBLE);
        iv_d.setVisibility(View.INVISIBLE);
        tv_e.setVisibility(View.INVISIBLE);
    }
}
