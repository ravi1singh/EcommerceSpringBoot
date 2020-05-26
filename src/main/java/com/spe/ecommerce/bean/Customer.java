package com.spe.ecommerce.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String address;
	private String city;
	private String country;
	private String creditCard;
	private String email;
	private String mobile;
	private String name;
	private String password;
	private String state;
	private String zipCode;
	
//	@ManyToMany
//	@JoinTable(name = "Customer_OrderedProduct", joinColumns = @JoinColumn(name="CUSTOMER_ID"),
//	inverseJoinColumns = @JoinColumn(name="PRODUCT_ID"))
//	private List<Product> previousOrders=new ArrayList<Product>();
//	 
	
	@ManyToMany
	@JoinTable(name = "Customer_Product", joinColumns = @JoinColumn(name="CUSTOMER_ID"),
	inverseJoinColumns = @JoinColumn(name="PRODUCT_ID"))
	private List<Product> cart=new ArrayList<Product>();
	
	
//	@OneToMany(targetEntity = Product.class, cascade= CascadeType.ALL)
//	@JoinColumn(name="customer_fk",referencedColumnName = "customerId")
//	private List<Product> cart=new ArrayList<Product>();
	

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
//	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Product> getCart() {
		return cart;
	}
	public void setCart(List<Product> cart) {
		this.cart = cart;
	}
//	public List<Product> getPreviousOrders() {
//		return previousOrders;
//	}
//	public void setPreviousOrders(List<Product> previousOrders) {
//		this.previousOrders = previousOrders;
//	}
}
