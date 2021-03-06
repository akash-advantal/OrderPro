package com.orderpro.customer.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.merchant.orderpro.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.orderpro.customer.DummyData;
import com.orderpro.customer.bean.ItemCategories;
import com.orderpro.customer.ui.NavigationActivity;
import com.orderpro.customer.ui.NotificationActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DashBoardParentFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {

    private Button drawer_icon, button_arrow;
    private LinearLayout arrowdown;
    private View hiddenPanel;
    private SliderLayout mDemoSlider;
    NavigationActivity navigationActivity;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;
    TextSliderView textSliderView;
    DummyData ddobj = new DummyData();
    public DashBoardChildFragment dashBoardChildFragment = new DashBoardChildFragment();
    ArrayList<ItemCategories> itemCategories;
    RippleView open_quik_orders, open_notification, open_chat;
    HashMap<String, Integer> file_maps;
    View view;


    // Declare
    Menu menu;
    MenuItem menuDoneItem;

    // Then in your onCreateOptionMenu() method write the following...
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        this.menu = menu;
        inflater.inflate(R.menu.menu_main, menu);
    }

    // In your onOptionItemSelected() method write the following...
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                this.menuDoneItem = item;
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_main, container, false);
        itemCategories = ddobj.initItemCategories();
//        setHasOptionsMenu(true);
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
//        getActivity().setSupportActionBar(toolbar);
//toolbar.showContextMenu();
        hiddenPanel = view.findViewById(R.id.slider);
        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);
        arrowdown = (LinearLayout) view.findViewById(R.id.arrowdown);
        drawer_icon = (Button) view.findViewById(R.id.drawer_icon);
        button_arrow = (Button) view.findViewById(R.id.button_arrow);
        open_quik_orders = (RippleView) view.findViewById(R.id.open_quik_orders);
        open_notification = (RippleView) view.findViewById(R.id.open_notification);
        open_chat = (RippleView) view.findViewById(R.id.open_chat);




        arrowdown.setOnClickListener(this);
        drawer_icon.setOnClickListener(this);
        open_quik_orders.setOnClickListener(this);
        open_notification.setOnClickListener(this);
        open_chat.setOnClickListener(this);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPagerTab = (SmartTabLayout) view.findViewById(R.id.viewpagertab);
        final FragmentPagerItems pages = new FragmentPagerItems(getActivity());

        for (ItemCategories titleResId : itemCategories) {
            pages.add(FragmentPagerItem.of(titleResId.getCategory(), dashBoardChildFragment.getClass()));
        }
        final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getChildFragmentManager(), pages);

        viewPager.setAdapter(adapter);

        viewPagerTab.setViewPager(viewPager);

        viewPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                Toast.makeText(getActivity(), itemCategories.get(position).getCategory(), Toast.LENGTH_SHORT).show();
//                if (itemCategories.get(position).getCategory().equals("Appliances")) {
//                    String value = "Appliances";
//                    DashBoardChildFragment   dashBoardChildFragment1 = (DashBoardChildFragment)adapter.getPage(position);
//                    dashBoardChildFragment1.insertTextView(value);
//                }
//                    DashBoardChildFragment   dashBoardChildFragment1 = (DashBoardChildFragment)adapter.getPage(position);
//                    dashBoardChildFragment1.insertTextView(value);

                DashBoardChildFragment dashBoardChildFragment1 = (DashBoardChildFragment) adapter.getPage(position);
                dashBoardChildFragment1.insertTextView(itemCategories.get(position).getCategory());
                dashBoardChildFragment1.hideTitleBar();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        file_maps = ddobj.initFileMaps();

        for (String name : file_maps.keySet()) {
            textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.startAutoCycle();
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        return view;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    //''''''''''''''''''''''''''''''''''hiding slider start''''''''''''''''''''

    public void slideUpDown(final View view) {
        if (!isPanelShown()) {
            // Show the panel
            Animation bottomUp = AnimationUtils.loadAnimation(getActivity(),
                    R.anim.bottom_up);
            button_arrow.setBackground(getResources().getDrawable(R.drawable.up_arrow));

            hiddenPanel.startAnimation(bottomUp);
            hiddenPanel.setVisibility(View.VISIBLE);
        } else {
            // Hide the Panel
            Animation bottomDown = AnimationUtils.loadAnimation(getActivity(),
                    R.anim.bottom_down);

            button_arrow.setBackground(getResources().getDrawable(R.drawable.down_arrow));
            hiddenPanel.startAnimation(bottomDown);
            hiddenPanel.setVisibility(View.GONE);
        }
    }
//''''''''''''''''''''''''''hiding slider close''''''''''''''''''''''''''''''''''

    private boolean isPanelShown() {
        return hiddenPanel.getVisibility() == View.VISIBLE;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigationActivity = (NavigationActivity) getActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.drawer_icon:
                navigationActivity.toggle();
                break;
            case R.id.arrowdown:
                slideUpDown(button_arrow);

                break;
            case R.id.open_quik_orders:
                Toast.makeText(getActivity(), "open_quik_orders", Toast.LENGTH_SHORT).show();

                break;
            case R.id.open_notification:
//               Toast.makeText(getActivity(), "open_notification", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), NotificationActivity.class));
                break;
            case R.id.open_chat:
//                menuDoneItem.setVisible(true);
                Toast.makeText(getActivity(), "open_chat", Toast.LENGTH_SHORT).show();
                break;

        }

    }

}