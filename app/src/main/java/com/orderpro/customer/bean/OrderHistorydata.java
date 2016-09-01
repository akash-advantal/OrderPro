package com.orderpro.customer.bean;

import java.io.Serializable;

public class OrderHistorydata implements Serializable
{
	String  item_title,item_content,item_decs;
			int item_image ;

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}

	public String getItem_decs() {
		return item_decs;
	}

	public void setItem_decs(String item_decs) {
		this.item_decs = item_decs;
	}

	public int getItem_image() {
		return item_image;
	}

	public void setItem_image(int item_image) {
		this.item_image = item_image;
	}

	public OrderHistorydata(String item_title, String item_content, String item_decs, int item_image) {

		this.item_title = item_title;
		this.item_content = item_content;
		this.item_decs = item_decs;
		this.item_image = item_image;
	}

	public OrderHistorydata() {

	}
}
