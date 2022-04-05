package com.luv2code.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootEcommerceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	// Test class added only to cover main() invocation not covered by application tests.
	@Test
   	void main() {
      	SpringBootEcommerceApplication.main(new String[] {});
   }
}
