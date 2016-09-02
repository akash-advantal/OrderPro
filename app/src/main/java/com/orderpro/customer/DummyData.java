package com.orderpro.customer;

import com.merchant.orderpro.R;
import com.orderpro.customer.bean.ItemCategories;
import com.orderpro.customer.bean.ItemDataDashBoardList;
import com.orderpro.customer.bean.OrderHistorydata;

import java.util.ArrayList;

/**
 * Created by bhghkhkh on 17-Aug-16.
 */
public class DummyData {

    public ArrayList<ItemDataDashBoardList> itemData = new ArrayList<>();
    public ArrayList<OrderHistorydata> orderlist = new ArrayList<OrderHistorydata>();
    public ArrayList<OrderHistorydata> notificationlist = new ArrayList<OrderHistorydata>();
    public ArrayList<OrderHistorydata> cartlist = new ArrayList<OrderHistorydata>();
    public ArrayList<ItemCategories> itemCategories = new ArrayList<ItemCategories>();


    public ArrayList<ItemCategories> initItemCategories() {

        itemCategories.add(new ItemCategories("Electronics"));
        itemCategories.add(new ItemCategories("Appliances"));
        itemCategories.add(new ItemCategories("Men"));
        itemCategories.add(new ItemCategories("Women"));
        itemCategories.add(new ItemCategories("Baby"));
        itemCategories.add(new ItemCategories("Kids"));
        itemCategories.add(new ItemCategories("Home & Furniture"));
        itemCategories.add(new ItemCategories("Books & More"));

        return itemCategories;
    }

    public void initParentData() {
        itemData.clear();

        itemData.add(new ItemDataDashBoardList("Mobiles", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Wearables", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Components", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Tablet", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Camera", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Accessories", R.drawable.product_img));
    }

    public void initMobileData() {
        itemData.clear();
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
        itemData.clear();
        itemData.add(new ItemDataDashBoardList("S series", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Galaxy", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("J series", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Note", R.drawable.product_img));

    }

    public void initMoblieSubCategoryThreeData() {
        itemData.clear();
        itemData.add(new ItemDataDashBoardList("Samsung S1", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("S2", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("S3", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("S4", R.drawable.product_img));

    }

    public void initChildData() {
        itemData.clear();
        itemData.add(new ItemDataDashBoardList("a", R.drawable.phone));
        itemData.add(new ItemDataDashBoardList("b", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("c", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("d", R.drawable.product_img));

    }

    public ArrayList<OrderHistorydata> initOrderList() {
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        return orderlist;
    }

    public ArrayList<OrderHistorydata> initCartList() {

        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        return cartlist;
    }

    public ArrayList<OrderHistorydata> initNotificationList() {

        notificationlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        notificationlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        notificationlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        notificationlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        return notificationlist;
    }

}
