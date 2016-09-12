package com.orderpro.customer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.merchant.orderpro.R;
import com.orderpro.customer.ui.NavigationActivity;

/**
 * Created by AKASH on 07-Sep-16.
 */

public class InviteFriendsFragment extends Fragment implements View.OnClickListener {
    NavigationActivity navigationActivity;
    View view;
    ImageView drawer_icon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_invite_friends, container, false);
        drawer_icon = (ImageView) view.findViewById(R.id.drawer_icon);

        drawer_icon.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.drawer_icon:
                navigationActivity.toggle();
                break;
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigationActivity = (NavigationActivity) getActivity();
    }

}