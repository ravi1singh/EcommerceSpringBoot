package com.spe.ecommerce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spe.ecommerce.Dao.Dao;
import com.spe.ecommerce.bean.AddToCart;
import com.spe.ecommerce.bean.Checkout;
import com.spe.ecommerce.bean.Customer;
import com.spe.ecommerce.bean.Login;
import com.spe.ecommerce.bean.UserDetails;
import com.spe.ecommerce.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

	@Autowired
	Dao dao;
	@Override
	public UserDetails validateUser(Login login) {
		
		return dao.validateUser(login);
	}
	@Override
	public boolean addToCart(AddToCart add_to_cart) {
		
		return dao.addToCart(add_to_cart);
		
	}
	@Override
	public boolean registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.registerCustomer(customer);
	}
	@Override
	public boolean checkoutMethod(Checkout checkout) {
		return dao.checkout(checkout);
	}
	
}
