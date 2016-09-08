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
import com.orderpro.customer.ui.ChangePassword;
import com.orderpro.customer.ui.MerchantDetailsActivity;
import com.orderpro.customer.ui.MyProfileActivity;
import com.orderpro.customer.ui.NavigationActivity;

/**
 * Created by AKASH on 07-Sep-16.
 */

public class SettingsFragment extends Fragment implements View.OnClickListener {
    NavigationActivity navigationActivity;
    View view;
    ImageView drawer_icon;
    LinearLayout my_profile, my_merchants, change_password, notification_settings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_settings, container, false);
        drawer_icon = (ImageView) view.findViewById(R.id.drawer_icon);
        my_profile = (LinearLayout) view.findViewById(R.id.my_profile);
        my_merchants = (LinearLayout) view.findViewById(R.id.my_merchants);
        change_password = (LinearLayout) view.findViewById(R.id.change_password);
        notification_settings = (LinearLayout) view.findViewById(R.id.notification_settings);

        drawer_icon.setOnClickListener(this);
        my_profile.setOnClickListener(this);
        my_merchants.setOnClickListener(this);
        change_password.setOnClickListener(this);
        notification_settings.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.drawer_icon:
                navigationActivity.toggle();
                break;
            case R.id.my_profile:
                startActivity(new Intent(getActivity(),MyProfileActivity.class));

                break;
            case R.id.my_merchants:
                startActivity(new Intent(getActivity(),MerchantDetailsActivity.class));

                break;
            case R.id.change_password:
                startActivity(new Intent(getActivity(),ChangePassword.class));

                break;
            case R.id.notification_settings:
                break;
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigationActivity = (NavigationActivity) getActivity();
    }

}