package com.luv2code.ecommerce.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentInfoTests {

	@Test
	public void createPaymentInfo() {

		PaymentInfo paymentInfo = new PaymentInfo();

		paymentInfo.setAmount(100);
		paymentInfo.setCurrency("USD");
		paymentInfo.setReceiptEmail("abc@email.com");

		assertEquals(100, paymentInfo.getAmount());
		assertEquals("USD", paymentInfo.getCurrency());
		assertEquals("abc@email.com", paymentInfo.getReceiptEmail());

	}

	@Test
	public void testToString() {

		PaymentInfo paymentInfo = new PaymentInfo();

		System.out.println(paymentInfo.toString());

	}

	@Test
	public void testHashCode() {

		PaymentInfo paymentInfo = new PaymentInfo();

		System.out.println(paymentInfo.hashCode());

	}

	@Test
	public void testEquals() {

		PaymentInfo paymentInfo = new PaymentInfo();
		PaymentInfo paymentInfo2 = new PaymentInfo();

		paymentInfo.equals(paymentInfo2);
		paymentInfo2.equals(paymentInfo);

	}

}
