package com.spe.ecommerce.Dao;

import com.spe.ecommerce.bean.AddToCart;
import com.spe.ecommerce.bean.Checkout;
import com.spe.ecommerce.bean.Customer;
import com.spe.ecommerce.bean.Login;
import com.spe.ecommerce.bean.UserDetails;

public interface Dao {
	public UserDetails validateUser(Login login);
	public boolean addToCart(AddToCart add_to_cart);
	public boolean registerCustomer(Customer customer);
	public boolean checkout(Checkout checkout);
}
