package com.orderpro.customer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.merchant.orderpro.R;
import com.orderpro.customer.bean.ItemCategories;
import com.orderpro.customer.fragments.DashBoardFragment;
import com.orderpro.customer.util.OnSwipeTouchListener;
import com.navdrawer.SimpleSideDrawer;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.HashMap;


public class DashBoardActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {
    LinearLayout switch_merchant,myorders, chat, setting,invite_friends,social_media_sharing,offers;
    View focusimage_switch_merchant,focusimage_myorders,focusimage_chat,focusimage_setting,focusimage_invite_friends,
            focusimage_social_media_sharing,focusimage_offers;



    SimpleSideDrawer nav;

    private Button arrow, navbtn;

    private View hiddenPanel;
    private SliderLayout mDemoSlider;

    // String[] schoolbag2 = {"Electronics", "Appliances", "Men", "Women", "Baby & Kids", "Home & Furniture", "Books & More"};
    private ArrayList<ItemCategories> itemCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav = new SimpleSideDrawer(this);
        initview();
        setCategoryItem();
        hiddenPanel = findViewById(R.id.slider);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        arrow = (Button) findViewById(R.id.arrowdown);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        final FragmentPagerItems pages = new FragmentPagerItems(this);
        for (ItemCategories titleResId : itemCategories) {


//            Toast.makeText(DashBoardActivity.this,  pages.get(0).getTitle().toString(), Toast.LENGTH_SHORT).show();
            pages.add(FragmentPagerItem.of(titleResId.getCategory(), DashBoardFragment.class));

        }


//  get title position
//        viewPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                Toast.makeText(DashBoardActivity.this,  pages.get(position).getTitle().toString(), Toast.LENGTH_SHORT).show();
////               String title=pages.get(position).getTitle().toString();
////                if(title.equals("Electronics")){
////
////                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);

        viewPagerTab.setViewPager(viewPager);

//        HashMap<String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Smartphones offers", R.drawable.mobile_sale);
        file_maps.put("clothing offers", R.drawable.clothing_offers);
        file_maps.put("Electronics Discount", R.drawable.electronics_offers);
        file_maps.put("Kitchen Utensils", R.drawable.kitchen_utensils);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
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
    }

    //''''''''''''''''''''''''''''''''''hiding slider start''''''''''''''''''''

    public void slideUpDown(final View view) {
        if (!isPanelShown()) {
            // Show the panel
            Animation bottomUp = AnimationUtils.loadAnimation(this,
                    R.anim.bottom_up);
            arrow.setBackground(getResources().getDrawable(R.drawable.up_arrow));

            hiddenPanel.startAnimation(bottomUp);
            hiddenPanel.setVisibility(View.VISIBLE);
        } else {
            // Hide the Panel
            Animation bottomDown = AnimationUtils.loadAnimation(this,
                    R.anim.bottom_down);

            arrow.setBackground(getResources().getDrawable(R.drawable.down_arrow));
            hiddenPanel.startAnimation(bottomDown);
            hiddenPanel.setVisibility(View.GONE);
        }
    }
//''''''''''''''''''''''''''hiding slider close''''''''''''''''''''''''''''''''''

    private boolean isPanelShown() {
        return hiddenPanel.getVisibility() == View.VISIBLE;
    }


    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    private void initview() {
        nav.setLeftBehindContentView(R.layout.navigation);
        nav.setAnimationDurationLeft(500);
        // navbtn = (LinearLayout) findViewById(R.id.order);
        navbtn = (Button) findViewById(R.id.drawer_icon);

        navbtn.setOnClickListener(this);
        nav.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
                //    Toast.makeText(SideMenu.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                //Toast.makeText(SideMenu.this, "right", Toast.LENGTH_SHORT).show();
                //nav.toggleLeftDrawer();

            }

            public void onSwipeLeft() {
                //  Toast.makeText(SideMenu.this, "left", Toast.LENGTH_SHORT).show();
                nav.toggleLeftDrawer();
            }

            public void onSwipeBottom() {
                //    Toast.makeText(SideMenu.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });



        focusimage_switch_merchant = (View) findViewById(R.id.focusimage_switch_merchant);
        focusimage_myorders = (View) findViewById(R.id.focusimage_myorders);
        focusimage_chat = (View) findViewById(R.id.focusimage_chat);
        focusimage_setting = (View) findViewById(R.id.focusimage_setting);
        focusimage_invite_friends = (View) findViewById(R.id.focusimage_invite_friends);
        focusimage_social_media_sharing = (View) findViewById(R.id.focusimage_social_media_sharing);
        focusimage_offers = (View) findViewById(R.id.focusimage_offers);



        switch_merchant = (LinearLayout) findViewById(R.id.switch_merchant);
        myorders = (LinearLayout) findViewById(R.id.myorders);
        chat = (LinearLayout) findViewById(R.id.chat);
        setting = (LinearLayout) findViewById(R.id.setting);
        invite_friends = (LinearLayout) findViewById(R.id.invite_friends);
        social_media_sharing = (LinearLayout) findViewById(R.id.social_media_sharing);
        offers = (LinearLayout) findViewById(R.id.offers);

        switch_merchant.setOnClickListener(this);
        myorders.setOnClickListener(this);
        chat.setOnClickListener(this);
        setting.setOnClickListener(this);
        invite_friends.setOnClickListener(this);
        social_media_sharing.setOnClickListener(this);
        offers.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.drawer_icon:
                nav.toggleLeftDrawer();
                break;
            case R.id.switch_merchant:
                setVisibility(R.id.switch_merchant);
                break;
            case R.id.myorders:
                startActivity(new Intent(DashBoardActivity.this,OrderHistoryActivity.class));
                setVisibility(R.id.myorders);
                break;
            case R.id.chat:
                setVisibility(R.id.chat);
                break;
            case R.id.setting:
                setVisibility(R.id.setting);
                break;
            case R.id.invite_friends:
                setVisibility(R.id.invite_friends);
                break;
            case R.id.social_media_sharing:
                setVisibility(R.id.social_media_sharing);
                break;
            case R.id.offers:
                setVisibility(R.id.offers);
                break;

        }

    }

    public void setVisibility(int id) {
        switch (id) {
            case R.id.switch_merchant:
                focusimage_switch_merchant.setVisibility(View.VISIBLE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_setting.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_social_media_sharing.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                break;
            case R.id.myorders:
                focusimage_myorders.setVisibility(View.VISIBLE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_setting.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_social_media_sharing.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                break;
            case R.id.chat:
                focusimage_chat.setVisibility(View.VISIBLE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_setting.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_social_media_sharing.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                break;
            case R.id.setting:
                focusimage_setting.setVisibility(View.VISIBLE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_social_media_sharing.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                break;
            case R.id.offers:
                focusimage_offers.setVisibility(View.VISIBLE);
                focusimage_setting.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_social_media_sharing.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                break;
            case R.id.social_media_sharing:
                focusimage_social_media_sharing.setVisibility(View.VISIBLE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_setting.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                focusimage_invite_friends.setVisibility(View.GONE);
                break;
            case R.id.invite_friends:
                focusimage_invite_friends.setVisibility(View.VISIBLE);
                focusimage_social_media_sharing.setVisibility(View.GONE);
                focusimage_offers.setVisibility(View.GONE);
                focusimage_setting.setVisibility(View.GONE);
                focusimage_chat.setVisibility(View.GONE);
                focusimage_myorders.setVisibility(View.GONE);
                focusimage_switch_merchant.setVisibility(View.GONE);
                break;
        }

    }

    public void setCategoryItem() {

        if (itemCategories.size() > 0) {
            itemCategories.clear();
        }
        itemCategories.add(new ItemCategories("Electronics"));
        itemCategories.add(new ItemCategories("Appliances"));
        itemCategories.add(new ItemCategories("Men"));
        itemCategories.add(new ItemCategories("Women"));
        itemCategories.add(new ItemCategories("Baby"));
        itemCategories.add(new ItemCategories("Kids"));
        itemCategories.add(new ItemCategories("Home & Furniture"));
        itemCategories.add(new ItemCategories("Books & More"));
    }


}