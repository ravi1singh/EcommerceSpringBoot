package com.spe.ecommerce.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {
	
	private int customerId;
	private String name;
	private List<Product> cart;
	private List<Product> allVisibleProducts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getCart() {
		return cart;
	}
	public void setCart(List<Product> cart) {
		this.cart = cart;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<Product> getAllVisibleProducts() {
		return allVisibleProducts;
	}
	public void setAllVisibleProducts(List<Product> allVisibleProducts) {
		this.allVisibleProducts = allVisibleProducts;
	}
}
