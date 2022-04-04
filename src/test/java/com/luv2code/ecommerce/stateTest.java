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

	@Test
	public void testAddress() {
		assertNotNull(checkoutController);
		
		Address address=new Address();	
		
		address.setZipCode("");
		address.setCity("");
		address.setCountry("");
		address.setId((long)1);
		address.setState("");
		address.setStreet("");
		
		assertTrue( address.getId()>0);
		assertTrue( address.getZipCode().equals(""));
		assertTrue( address.getCity().equals(""));
		assertTrue( address.getCountry().equals(""));
		assertTrue( address.getState().equals(""));
		assertTrue( address.getStreet().equals(""));
		
	}
}
