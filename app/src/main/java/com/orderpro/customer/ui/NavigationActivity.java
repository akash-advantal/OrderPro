package com.orderpro.customer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.merchant.orderpro.R;
import com.navdrawer.SimpleSideDrawer;
import com.orderpro.customer.fragments.DashBoardParentFragment;
import com.orderpro.customer.fragments.FavouritesFragment;
import com.orderpro.customer.fragments.InviteFriendsFragment;
import com.orderpro.customer.fragments.OrderHistoryFragment;
import com.orderpro.customer.fragments.SettingsFragment;
import com.orderpro.customer.fragments.SupportFragment;
import com.orderpro.customer.util.OnSwipeTouchListener;

/**
 * Created by AKASH on 30-Aug-16.
 */
public class NavigationActivity extends FragmentActivity implements View.OnClickListener {

    LinearLayout switch_merchant, myorders, chat, settings, invite_friends, support, offers, home, myfav;
    View focusimage_switch_merchant, focusimage_myorders, focusimage_chat, focusimage_settings, focusimage_invite_friends,
            focusimage_support, focusimage_offers, focusimage_home, focusimage_myfav;

    FragmentManager fragmentManager;
    SimpleSideDrawer navigationDrawer;

    private Button navbtn;
//    private ArrayList<ItemCategories> itemCategories = new ArrayList<>();

    //    private View hiddenPanel;
//    private SliderLayout mDemoSlider;
    FragmentTransaction fragmentTransaction;
//    DashBoardChildFragment dashBoardChildFragment = new DashBoardChildFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_frame);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, new DashBoardParentFragment());
        fragmentTransaction.commit();
        navigationDrawer = new SimpleSideDrawer(this);
        initview();


    }


    public void initview() {
        navigationDrawer.setLeftBehindContentView(R.layout.navigation);
        navigationDrawer.setAnimationDurationLeft(500);
        navbtn = (Button) findViewById(R.id.drawer_icon);
        navigationDrawer.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
                //    Toast.makeText(SideMenu.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                //Toast.makeText(SideMenu.this, "right", Toast.LENGTH_SHORT).show();
                //navigationDrawer.toggleLeftDrawer();

            }

            public void onSwipeLeft() {
                //  Toast.makeText(SideMenu.this, "left", Toast.LENGTH_SHORT).show();
                navigationDrawer.toggleLeftDrawer();
            }

            public void onSwipeBottom() {
                //    Toast.makeText(SideMenu.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });


        focusimage_home = (View) navigationDrawer.findViewById(R.id.focusimage_home);
        focusimage_switch_merchant = (View) navigationDrawer.findViewById(R.id.focusimage_switch_merchant);
        focusimage_myorders = (View) navigationDrawer.findViewById(R.id.focusimage_myorders);
        focusimage_chat = (View) navigationDrawer.findViewById(R.id.focusimage_chat);
        focusimage_myfav = (View) navigationDrawer.findViewById(R.id.focusimage_myfav);
        focusimage_settings = (View) navigationDrawer.findViewById(R.id.focusimage_settings);
        focusimage_invite_friends = (View) navigationDrawer.findViewById(R.id.focusimage_invite_friends);
        focusimage_support = (View) navigationDrawer.findViewById(R.id.focusimage_support);
        focusimage_offers = (View) navigationDrawer.findViewById(R.id.focusimage_offers);


        home = (LinearLayout) navigationDrawer.findViewById(R.id.home);
        switch_merchant = (LinearLayout) navigationDrawer.findViewById(R.id.switch_merchant);
        myorders = (LinearLayout) navigationDrawer.findViewById(R.id.myorders);
        chat = (LinearLayout) navigationDrawer.findViewById(R.id.chat);
        myfav = (LinearLayout) navigationDrawer.findViewById(R.id.myfav);
        settings = (LinearLayout) navigationDrawer.findViewById(R.id.settings);
        invite_friends = (LinearLayout) navigationDrawer.findViewById(R.id.invite_friends);
        support = (LinearLayout) navigationDrawer.findViewById(R.id.support);
        offers = (LinearLayout) navigationDrawer.findViewById(R.id.offers);


        switch_merchant.setOnClickListener(this);
        myorders.setOnClickListener(this);
        chat.setOnClickListener(this);
        myfav.setOnClickListener(this);
        settings.setOnClickListener(this);
        invite_friends.setOnClickListener(this);
        support.setOnClickListener(this);
        offers.setOnClickListener(this);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.drawer_icon:
                fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.frame, new DashBoardParentFragment());
                fragmentTransaction.commit();
                navigationDrawer.toggleLeftDrawer();
                break;

            case R.id.home:
                fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.frame, new DashBoardParentFragment());
                fragmentTransaction.commit();
                navigationDrawer.toggleLeftDrawer();
                setVisibility(R.id.home);
                break;
            case R.id.switch_merchant:
                setVisibility(R.id.switch_merchant);
                break;
            case R.id.myorders:
                fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.frame, new OrderHistoryFragment());
                fragmentTransaction.commit();
                navigationDrawer.toggleLeftDrawer();
                setVisibility(R.id.myorders);
                break;
            case R.id.chat:
                setVisibility(R.id.chat);
                break;
            case R.id.settings:
                fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.frame, new SettingsFragment());
                fragmentTransaction.commit();
                navigationDrawer.toggleLeftDrawer();
                setVisibility(R.id.settings);
                break;
            case R.id.invite_friends:
                fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.frame, new InviteFriendsFragment());
                fragmentTransaction.commit();
                navigationDrawer.toggleLeftDrawer();
                setVisibility(R.id.invite_friends);
                break;
            case R.id.support:
                fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.frame, new SupportFragment());
                fragmentTransaction.commit();
                navigationDrawer.toggleLeftDrawer();
                setVisibility(R.id.support);
                break;
            case R.id.offers:
                setVisibility(R.id.offers);
                break;
            case R.id.myfav:
                fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.frame, new FavouritesFragment());
                fragmentTransaction.commit();
                navigationDrawer.toggleLeftDrawer();
                setVisibility(R.id.myfav);
                break;
        }

    }

    public void setVisibility(int id) {
        switch (id) {
            case R.id.home:
                focusimage_home.setVisibility(View.VISIBLE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;
            case R.id.switch_merchant:
                focusimage_switch_merchant.setVisibility(View.VISIBLE);
                focusimage_home.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;

            case R.id.myorders:
                focusimage_myorders.setVisibility(View.VISIBLE);
                focusimage_home.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;
            case R.id.chat:
                focusimage_chat.setVisibility(View.VISIBLE);
                focusimage_home.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;
            case R.id.myfav:
                focusimage_myfav.setVisibility(View.VISIBLE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_home.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                break;

            case R.id.settings:
                focusimage_home.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.VISIBLE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;

            case R.id.offers:
                focusimage_offers.setVisibility(View.VISIBLE);
                focusimage_home.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;

            case R.id.support:
                focusimage_support.setVisibility(View.VISIBLE);
                focusimage_home.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;

            case R.id.invite_friends:
                focusimage_invite_friends.setVisibility(View.VISIBLE);
                focusimage_home.setVisibility(View.GONE);
                focusimage_support.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_settings.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_myfav.setVisibility(View.GONE);
                break;

        }


    }


    public void toggle() {
        navigationDrawer.toggleLeftDrawer();
    }
}
