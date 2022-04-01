package com.luv2code.ecommerce;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.ecommerce.controller.CheckoutController;
import com.luv2code.ecommerce.entity.Address;

public class stateTest  extends SpringBootEcommerceApplicationTests {
	@Autowired
	private CheckoutController checkoutController;

	private Address address=new Address();
	
	@Test
	public void testObject() {
		address.setZipCode("12345");
		 assertNotNull(checkoutController);
		 assertTrue( address.getZipCode().equals("12345"));
	}
}
