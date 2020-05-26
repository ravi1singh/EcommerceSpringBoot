package com.spe.ecommerce.bean;

import java.util.ArrayList;

public class Checkout {
	
	private int customerId;
	//private ArrayList<Integer> checkoutlists;
	private String checkoutlist;
//	public ArrayList<Integer> getCheckoutlist() {
//		return this.checkoutlists;
//	}
//
//	public void setCheckoutlist(ArrayList<Integer> checkoutlist) {
//		this.checkoutlists = checkoutlist;
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCheckoutlist() {
		return checkoutlist;
	}

	public void setCheckoutlist(String checkoutlist) {
		this.checkoutlist = checkoutlist;
	}
}
