package com.orderpro.customer.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.merchant.orderpro.R;
import com.orderpro.customer.ui.ContactusActivity;
import com.orderpro.customer.ui.NavigationActivity;
import com.orderpro.customer.ui.TermsofuseActivity;

/**
 * Created by AKASH on 08-Sep-16.
 */

public class SupportFragment extends Fragment implements View.OnClickListener {
    NavigationActivity navigationActivity;
    View view;
    ImageView drawer_icon;
    LinearLayout contact_us, terms_of_use, faqs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_support, container, false);
        drawer_icon = (ImageView) view.findViewById(R.id.drawer_icon);
        contact_us = (LinearLayout) view.findViewById(R.id.my_profile);
        terms_of_use = (LinearLayout) view.findViewById(R.id.my_merchants);
        faqs = (LinearLayout) view.findViewById(R.id.change_password);


        drawer_icon.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        terms_of_use.setOnClickListener(this);
        faqs.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.drawer_icon:
                navigationActivity.toggle();
                break;
            case R.id.my_profile:
                startActivity(new Intent(getActivity(),ContactusActivity.class));
                break;
            case R.id.my_merchants:
                startActivity(new Intent(getActivity(),TermsofuseActivity.class));
                break;
            case R.id.change_password:
//                navigationActivity.toggle();
                break;
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigationActivity = (NavigationActivity) getActivity();
    }

}