package com.luv2code.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.luv2code.ecommerce.dto;

@SpringBootTest
class SpringBootEcommerceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testPurchase(){
		Purchase pc=new Purchase();
		pc.setCustomer("aa");
		assertTrue(pc.getCustomer.equal("aa"));
    }
}
