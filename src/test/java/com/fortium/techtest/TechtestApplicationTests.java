package com.fortium.techtest;

import com.fortium.techtest.DAO.ProductDAO;
import com.fortium.techtest.controller.ProductController;
import com.fortium.techtest.entity.Product;
import com.fortium.techtest.repository.ProductRepository;
import com.fortium.techtest.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class TechtestApplicationTests {

	private ProductController productController;

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() {
		productController = new ProductController(productService);
	}

	@Test
	@WithMockUser(roles = {"USER"})
	public void productReturned()
	{
		ProductDAO productDAO = productController.findBySku("TST0001");
		assertEquals(productDAO.getName(), "Test 1");
	}

	@Test
	public void productSaved()
	{
		ProductDAO productDAO = new ProductDAO();
		productDAO.setName("Test");
		productDAO.setShortDescription("Test short desc");
		productDAO.setDescription("Test desc");
		productDAO.setSku("TST0009");
		productDAO.setPrice(11F);
		URI location = restTemplate.withBasicAuth("admin", "admin").postForLocation("http://localhost:"+port+"/products", productDAO);

		assertTrue(location.getPath().contains("products/TST0009"));
	}

}
