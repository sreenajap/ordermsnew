package com.infosys.project.Order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.Order.dto.ProductsOrderedDTO;
import com.infosys.project.Order.service.ProductsOrderedService;

@RestController
@CrossOrigin
@RequestMapping(value="/productsordered")
public class ProductsOrderedController {

		Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		ProductsOrderedService productsOrderedService;

		// Fetches all order details
		@GetMapping(value = "",  produces = MediaType.APPLICATION_JSON_VALUE)
		public List<ProductsOrderedDTO> getAllPlans() {
			logger.info("Fetching all products ordered");
			return productsOrderedService.getAllProductsOrdered();
		}
		
		// Fetch order details of a specific order
		@GetMapping(value = "/{prodId}",  produces = MediaType.APPLICATION_JSON_VALUE)
		public List<ProductsOrderedDTO> getSpecificPlans(@PathVariable Integer prodId) {
			logger.info("Fetching details of products ordered {}",prodId);
			return productsOrderedService.getSpecificProductsOrdered(prodId);
		}
		
		// Create a new order
		@PostMapping(value = "/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
		public void createCustomer(@RequestBody ProductsOrderedDTO productsOrderedDTO) {
			logger.info("Creation request for products ordered {}", productsOrderedDTO);
			productsOrderedService.createProductsOrdered(productsOrderedDTO);
		}
		
}
