package com.orderpro.customer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.merchant.orderpro.R;

import java.util.HashMap;


public class ProductActivity extends AppCompatActivity {
//        implements BaseSliderView.OnSliderClickListener {
//        ViewPagerEx.OnPageChangeListener {
ImageView iv_back;

    private SliderLayout mDemoSlider;
    private View hiddenPanel;
    private LinearLayout description;
    private ImageView addimg;
//    private Toolbar tool;
//    private Button arrow;
//    String[] schoolbag2 = {"Electronics", "Appliances", "Men", "Women", "Baby & Kids", "Home & Furniture", "Books & More"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        hiddenPanel = findViewById(R.id.image_slider);
        description = (LinearLayout) findViewById(R.id.descripdtl);
        addimg = (ImageView) findViewById(R.id.arrowchag);
//        arrow = (Button) findViewById(R.id.arrowdown);
//        tool = (Toolbar) findViewById(R.id.toolbar);

//        setSupportActionBar(tool);

        mDemoSlider = (SliderLayout) findViewById(R.id.image_slider);

        addimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (description.getVisibility() == View.VISIBLE)
                {
                    description.setVisibility(View.GONE);
                    addimg.setBackground(getResources().getDrawable(R.drawable.add_iicon));
                }
                else
                {
                    description.setVisibility(View.VISIBLE);
                    addimg.setBackground(getResources().getDrawable(R.drawable.collapse));
                }
            }
        });

//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);

//        FragmentPagerItems pages = new FragmentPagerItems(this);
//        for (String titleResId : schoolbag2) {
//            pages.add(FragmentPagerItem.of(titleResId, DemoFragments.class));
//        }

//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
//                getSupportFragmentManager(), pages);

//        viewPager.setAdapter(adapter);
//        viewPagerTab.setViewPager(viewPager);
//
//        HashMap<String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        iv_back =  (ImageView)  findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Smartphones offers", R.drawable.snewfour);
        file_maps.put("clothing offers", R.drawable.snewone);
        file_maps.put("Electronics Discount", R.drawable.snewthree);
        file_maps.put("Kitchen Utensils", R.drawable.snewtwo);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
//                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
//                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
//        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(10000);
//        mDemoSlider.addOnPageChangeListener(this);


    }
//''''''''''''''''''''''''''''''''''hiding slider start''''''''''''''''''''

//    public void slideUpDown(final View view) {
//        if (!isPanelShown()) {
//            // Show the panel
//            Animation bottomUp = AnimationUtils.loadAnimation(this,
//                    R.anim.bottom_up);
//            arrow.setBackground(getResources().getDrawable(R.drawable.up_arrow));
//
//            hiddenPanel.startAnimation(bottomUp);
//            hiddenPanel.setVisibility(View.VISIBLE);
//        } else {
//            // Hide the Panel
//            Animation bottomDown = AnimationUtils.loadAnimation(this,
//                    R.anim.bottom_down);
//
//            arrow.setBackground(getResources().getDrawable(R.drawable.down_arrow));
//            hiddenPanel.startAnimation(bottomDown);
//            hiddenPanel.setVisibility(View.GONE);
//        }
//    }
//''''''''''''''''''''''''''hiding slider close''''''''''''''''''''''''''''''''''
//
//    private boolean isPanelShown() {
//        return hiddenPanel.getVisibility() == View.VISIBLE;
//    }

//
//    @Override
//    protected void onStop() {
//        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
//        mDemoSlider.stopAutoCycle();
//        super.onStop();
//    }

//    @Override
//    public void onSliderClick(BaseSliderView slider) {}
//    {
//        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
//    }

    //    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        Log.d("Slider Demo", "Page Changed: " + position);
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//    }
//'''''''''''''''''''''''this code is for the option view of menu three dots'''''''''''''''''''''''''''
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }
}
//'''''''''''''''''''''''''''''this is for open option menu item'''''''''''''''''''''''''''''''


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//
//        int id = item.getItemId();
//
//
//        if (id == R.id.action_settings) {
//
//            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
//            return true;
//        } else if (id == R.id.item1) {
//            Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.item2) {
//            Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.item3) {
//            Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.item4) {
//            Toast.makeText(this, "item4", Toast.LENGTH_SHORT).show();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
//''''''''''''''''''''''''''''close of option menu android''''''''''''''