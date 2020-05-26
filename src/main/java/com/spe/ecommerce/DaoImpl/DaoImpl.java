package com.spe.ecommerce.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spe.ecommerce.Dao.Dao;
import com.spe.ecommerce.bean.AddToCart;
import com.spe.ecommerce.bean.Checkout;
import com.spe.ecommerce.bean.Customer;
import com.spe.ecommerce.bean.Login;
import com.spe.ecommerce.bean.Product;
import com.spe.ecommerce.bean.UserDetails;

@Repository
@Transactional
public class DaoImpl implements Dao{
		@PersistenceContext
		EntityManager entityManager;
		@Autowired
		UserDetails userDetails;
		
		public UserDetails validateUser(Login login) {
			
			Query query= entityManager.createQuery("select c from Customer c where c.email=:email and c.password=:password");
			query.setParameter("email",login.getEmail());
			query.setParameter("password", login.getPassword());
			@SuppressWarnings("unchecked")
			List<Customer> list=query.getResultList();
			
			
			if( list.size()==1) {
				Customer customer=list.get(0);
				query= entityManager.createQuery("select p from Product p where p.location=:location");
				query.setParameter("location",customer.getCity());
				
				@SuppressWarnings("unchecked")
				List<Product> productlist= query.getResultList();
				
				userDetails.setName(customer.getName());
				userDetails.setCart(customer.getCart());
				userDetails.setCustomerId(customer.getCustomerId());
				userDetails.setAllVisibleProducts(productlist);
				System.out.println(userDetails);
				return userDetails;
			}
			System.out.println(list.size());
			return null;
		}

		@Override
		public boolean addToCart(AddToCart add_to_cart) {
		
			Customer customer=entityManager.find(Customer.class, add_to_cart.getCustomerId());
				if(customer==null)
						return false;
			
			Product product=entityManager.find(Product.class, add_to_cart.getProductId());
				if(product==null)
						return false;
			
				customer.getCart().add(product);
				
			return entityManager.merge(customer)!=null;
		}

		@Override
		public boolean registerCustomer(Customer customer) {
			return entityManager.merge(customer) != null;
		}

		
		
		@Override
		public boolean checkout(Checkout checkout) {
		
			int customerId=checkout.getCustomerId();
			int size=checkout.getCheckoutlist().length();
			String str=checkout.getCheckoutlist().substring(1, size-1);
			String temp[] = str.split(",");
			List<Integer>productlist=new ArrayList<Integer>();
			for(int i=0;i<temp.length;i++) {
				productlist.add(Integer.parseInt(temp[i]));
			}
			System.out.println(productlist);
			
			
			Query query=entityManager.createQuery("update Product p set p.productCount=p.productCount-1 where p.productId in (:productlist)");
			query.setParameter("productlist", productlist);
			
			if(query.executeUpdate()!=productlist.size())
				return false;
			
			Customer customer=entityManager.find(Customer.class, customerId);
			customer.getCart().clear();
			entityManager.merge(customer);
			return true;
//			
//			query=entityManager.createQuery("select p from Product p where p in (:productlist)");
//			query.setParameter("productlist", checkout.getCheckoutlist());
//			
//			@SuppressWarnings("unchecked")
//			List<Product> products = query.getResultList();
//			
//			Customer customer = entityManager.find(Customer.class,checkout.getCustomerId());
//			//customer.getPreviousOrders().addAll(products);
//			
//			entityManager.merge(customer);
		}
}
