package com.orderpro.customer.bean;

import java.io.Serializable;

public class MerchantListData implements Serializable
{
	String  merchant_name,merchant_no,merchant_adress;

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getMerchant_no() {
		return merchant_no;
	}

	public void setMerchant_no(String merchant_no) {
		this.merchant_no = merchant_no;
	}

	public String getMerchant_adress() {
		return merchant_adress;
	}

	public void setMerchant_adress(String merchant_adress) {
		this.merchant_adress = merchant_adress;
	}

	public MerchantListData(String merchant_name, String merchant_no, String merchant_adress) {

		this.merchant_name = merchant_name;
		this.merchant_no = merchant_no;
		this.merchant_adress = merchant_adress;
	}

	public MerchantListData() {

	}
}
