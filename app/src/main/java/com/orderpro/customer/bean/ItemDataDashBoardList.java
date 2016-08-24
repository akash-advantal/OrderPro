package com.orderpro.customer.bean;

/**
 * Created by SHRIG on 7/26/2016.
 */

public class ItemDataDashBoardList {


    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    private int imageUrl;

    public ItemDataDashBoardList(String title, int imageUrl){

        this.title = title;
        this.imageUrl = imageUrl;
    }
    // getters & setters
}