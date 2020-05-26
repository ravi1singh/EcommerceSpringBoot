package com.spe.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spe.ecommerce.bean.AddToCart;
import com.spe.ecommerce.bean.Checkout;
import com.spe.ecommerce.bean.Customer;
import com.spe.ecommerce.bean.Login;
import com.spe.ecommerce.bean.UserDetails;
import com.spe.ecommerce.service.Service;

@RestController
public class Controller {
	@Autowired
	Service service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public UserDetails loginController(@RequestBody Login login) {
		System.out.println(login.getEmail());
		System.out.println(login.getPassword());
		UserDetails userDetail=service.validateUser(login);
		System.out.println(userDetail);
		return userDetail;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addtocart")
	public boolean AddToCartController(@RequestBody AddToCart add_to_cart ) {
		return service.addToCart(add_to_cart);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public boolean registerCustomer(@RequestBody Customer customer) {
		System.out.println(customer.getZipCode());
		return service.registerCustomer(customer);
	}																																																																																																																																																																																																																																																																																																																													
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/checkout")
	public boolean checkoutMethod(@RequestBody Checkout checkout) {
		System.out.println(checkout.getCustomerId());
		System.out.println(checkout.getCheckoutlist());
		return service.checkoutMethod(checkout);
	}
	
}
