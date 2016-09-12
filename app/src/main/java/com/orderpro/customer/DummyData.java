package com.orderpro.customer;

import com.merchant.orderpro.R;
import com.orderpro.customer.bean.CartData;
import com.orderpro.customer.bean.ItemCategories;
import com.orderpro.customer.bean.ItemDataDashBoardList;
import com.orderpro.customer.bean.MerchantListData;
import com.orderpro.customer.bean.NotificationData;
import com.orderpro.customer.bean.OrderHistorydata;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Akash on 17-Aug-16.
 */
public class DummyData {

    public ArrayList<ItemDataDashBoardList> itemData = new ArrayList<ItemDataDashBoardList>();

    public ArrayList<OrderHistorydata> orderlist = new ArrayList<OrderHistorydata>();
    public ArrayList<NotificationData> notificationlist = new ArrayList<NotificationData>();
    public ArrayList<CartData> cartlist = new ArrayList<CartData>();
    public ArrayList<MerchantListData> merchantList = new ArrayList<MerchantListData>();
    public ArrayList<ItemCategories> itemCategories = new ArrayList<ItemCategories>();
    HashMap<String, Integer> file_maps = new HashMap<>();




//    HashMap<String, Integer> file_maps ;

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
    public void initAppliancesData() {
        itemData.clear();
        itemData.add(new ItemDataDashBoardList("Home Entertainment", R.drawable.phone));
        itemData.add(new ItemDataDashBoardList("Small Home Aplliances", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Refrigerators", R.drawable.product_img));
        itemData.add(new ItemDataDashBoardList("Kitchen", R.drawable.product_img));

    }

    public ArrayList<OrderHistorydata> initOrderList() {
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        orderlist.add(new OrderHistorydata("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        return orderlist;
    }

    public ArrayList<CartData> initCartList() {

        cartlist.add(new CartData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new CartData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new CartData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        cartlist.add(new CartData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        return cartlist;
    }

    public ArrayList<NotificationData> initNotificationList() {

        notificationlist.add(new NotificationData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        notificationlist.add(new NotificationData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        notificationlist.add(new NotificationData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        notificationlist.add(new NotificationData("Elegant Blue Shirt", "Delivery Status - Pending", "Delivered by 31, july, 2016", R.drawable.ic_launcher));
        return notificationlist;
    }
    public HashMap<String, Integer> initFileMaps() {

        file_maps.put("Smartphones offers", R.drawable.mobile_sale);
        file_maps.put("clothing offers", R.drawable.clothing_offers);
        file_maps.put("Electronics Discount", R.drawable.electronics_offers);
        file_maps.put("Kitchen Utensils", R.drawable.kitchen_utensils);
        return file_maps;
    }


    public ArrayList<MerchantListData> initmerchantList() {

        merchantList.add(new MerchantListData("Ayush Bhatnagar","901234567","510, 6th Floor, Shagun Complex , AB Road, Vijay Nagar, Indore - 452010, Above Apna Sweets"));
        merchantList.add(new MerchantListData("Ayush Bhatnagar","901234567","510, 6th Floor, Shagun Complex , AB Road, Vijay Nagar, Indore - 452010, Above Apna Sweets"));
        merchantList.add(new MerchantListData("Ayush Bhatnagar","901234567","510, 6th Floor, Shagun Complex , AB Road, Vijay Nagar, Indore - 452010, Above Apna Sweets"));
        merchantList.add(new MerchantListData("Ayush Bhatnagar","901234567","510, 6th Floor, Shagun Complex , AB Road, Vijay Nagar, Indore - 452010, Above Apna Sweets"));
        return merchantList;
    }


}
