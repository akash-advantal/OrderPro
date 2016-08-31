package com.orderpro.customer;

import com.merchant.orderpro.R;
import com.orderpro.customer.adapter.DashBoardAdapter;
import com.orderpro.customer.bean.ItemDataDashBoardList;

import java.util.ArrayList;

/**
 * Created by hgvh chfch on 17-Aug-16.
 */
public class DummyData {


    private DashBoardAdapter mAdapter;
    public ArrayList<ItemDataDashBoardList> itemData = new ArrayList<>();








    public  void initParentData() {
        if (itemData.size() > 0) {
            itemData.clear();
        }
        itemData.add(new ItemDataDashBoardList("Mobiles", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Wearables", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Components", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Tablet", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Camera", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Accessories", R.drawable.product_img));
    }
    public void initMobileData() {
        if (itemData.size() > 0) {
            itemData.clear();
        }
        itemData.add(new ItemDataDashBoardList("Samsung", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Nokia", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Moto", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Lumia", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Asus", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("HTC", R.drawable.product_img));
    }
    public void initMoblieSubCategoryOneData() {
        if (itemData.size() > 0) {
            itemData.clear();
        }
        itemData.add(new ItemDataDashBoardList("SmartPhone", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Basic Phone", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Android Phone", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Windows", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Symbian", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Bada", R.drawable.product_img));
    }
    public void initMoblieSubCategoryTwoData() {
        if (itemData.size() > 0) {
            itemData.clear();
        }
        itemData.add(new ItemDataDashBoardList("S series", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Galaxy", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("J series", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Note", R.drawable.product_img));

    }
    public void initMoblieSubCategoryThreeData() {
        if (itemData.size() > 0) {
            itemData.clear();
        }
        itemData.add(new ItemDataDashBoardList("Samsung S1", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("S2", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("S3", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("S4", R.drawable.product_img));

    }
    public void initChildData() {
        if (itemData.size() > 0) {
            itemData.clear();
        }
        itemData.add(new ItemDataDashBoardList("a", R.drawable.phone));
        itemData.add(new ItemDataDashBoardList("b", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("c", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("d", R.drawable.product_img));

    }


}
