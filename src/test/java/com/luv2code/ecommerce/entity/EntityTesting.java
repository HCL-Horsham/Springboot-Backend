package com.luv2code.ecommerce.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.luv2code.ecommerce.SpringBootEcommerceApplicationTests;

public class EntityTesting extends SpringBootEcommerceApplicationTests {

	@Test
	public void testCountryStateEntity() {
		// Country Testing
		Country c = new Country();
		c.setCode("");
		c.setId(1);
		c.setName("");

		// State Testing
		State st = new State();
		st.setCountry(c);
		st.setId(1);
		st.setName("");

		List<State> sts = new ArrayList<State>();
		sts.add(st);
		c.setStates(sts);

		assertTrue(c.getId() == 1);
		assertTrue(c.getCode().equals(""));
		assertTrue(c.getName().equals(""));

		assertTrue(st.getId() == 1);
		assertTrue(st.getCountry() != null);
		assertTrue(st.getName().equals(""));
	}

	@Test
	public void testProductEntity() {

		// ProductCategory Testing
		ProductCategory pc = new ProductCategory();

		pc.setCategoryName("");
		pc.setId((long) 1);

		assertTrue(pc.getId() > 0);
		assertTrue(pc.getCategoryName().equals(""));

		// Product Testing

		Product pd = new Product();

		pd.setActive(false);
		pd.setCategory(pc);
		pd.setDateCreated(new Date(System.currentTimeMillis()));
		pd.setDescription("");
		pd.setId((long) 1);
		pd.setImageUrl("");
		pd.setLastUpdated(new Date(System.currentTimeMillis()));
		pd.setName("");
		pd.setSku("");
		pd.setUnitPrice(BigDecimal.valueOf(1));
		pd.setUnitsInStock(0);

		assertTrue(pd.getId() > 0);
		assertTrue(pd.getCategory() != null);
		assertTrue(pd.getDateCreated() != null);
		assertTrue(pd.getDescription().equals(""));
		assertTrue(pd.getImageUrl().equals(""));
		assertTrue(pd.getLastUpdated() != null);
		assertTrue(pd.getName().equals(""));
		assertTrue(pd.getSku().equals(""));
		assertTrue(pd.getUnitPrice() == BigDecimal.valueOf(1));
		assertTrue(pd.getUnitsInStock() == 0);
	}

	@Test
	public void testOtherEntity() {

		// Customer testing
		Customer ct = new Customer();
		ct.setEmail("");
		ct.setFirstName("");
		ct.setId((long) 1);
		ct.setLastName("");
		ct.add(null);

		assertTrue(ct.getEmail().equals(""));
		assertTrue(ct.getFirstName().equals(""));
		assertTrue(ct.getId() > 0);
		assertTrue(ct.getLastName().equals(""));
		assertTrue(ct.getOrders() != null);

		// Address testing

		Address address = new Address();
		address.setZipCode("");
		address.setCity("");
		address.setCountry("");
		address.setId((long) 1);
		address.setState("");
		address.setStreet("");

		assertTrue(address.getId() > 0);
		assertTrue(address.getZipCode().equals(""));
		assertTrue(address.getCity().equals(""));
		assertTrue(address.getCountry().equals(""));
		assertTrue(address.getState().equals(""));
		assertTrue(address.getStreet().equals(""));

		// Order testing
		Order od = new Order();
		od.setBillingAddress(address);
		od.setCustomer(ct);
		od.setDateCreated(new Date(System.currentTimeMillis()));
		od.setId((long) 1);
		od.setOrderTrackingNumber("");
		od.setShippingAddress(address);
		od.setStatus("");
		od.setTotalPrice(BigDecimal.valueOf(1));
		od.setTotalQuantity(0);
		od.add(null);

		assertTrue(od.getId() > 0);
		assertTrue(od.getOrderTrackingNumber().equals(""));
		assertTrue(od.getStatus().equals(""));
		assertTrue(od.getTotalPrice().equals(BigDecimal.valueOf(1)));
		assertTrue(od.getTotalQuantity() == 0);
		assertTrue(od.getBillingAddress() != null);
		assertTrue(od.getShippingAddress() != null);
		assertTrue(od.getOrderItems() != null);

		// OrderItem Testing
		OrderItem odit = new OrderItem();
		odit.setId((long) 1);
		odit.setImageUrl("");
		odit.setProductId((long) 1);
		odit.setQuantity(1);
		odit.setUnitPrice(BigDecimal.valueOf(1));
		odit.setOrder(od);
		address.setOrder(od);

		Set<Order> sOd = new HashSet();
		sOd.add(od);
		ct.setOrders(sOd);

		Set<OrderItem> sOditem = new HashSet();
		sOditem.add(odit);
		od.setOrderItems(sOditem);

		assertTrue(odit.getId() > 0);
		assertTrue(odit.getImageUrl().equals(""));
		assertTrue(odit.getOrder() != null);
		assertTrue(odit.getProductId() > 0);
		assertTrue(odit.getQuantity() > 0);
		assertTrue(odit.getUnitPrice() == BigDecimal.valueOf(1));

		// Related Testing
		address.setOrder(od);

		ct.add(od);
		assertTrue(od.getOrderItems() != null);

		od.add(odit);
		assertTrue(ct.getOrders() != null);
		assertTrue(od.getOrderItems() != null);
		assertTrue(address.getOrder() != null);

	}
}
