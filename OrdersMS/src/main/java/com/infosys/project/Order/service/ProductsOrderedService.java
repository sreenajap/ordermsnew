package com.infosys.project.Order.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project.Order.dto.ProductsOrderedDTO;
import com.infosys.project.Order.entity.ProductsOrdered;
import com.infosys.project.Order.repository.ProductsOrderedRepository;

@Service
public class ProductsOrderedService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductsOrderedRepository productsOrderedRepo;

	// Fetches all products ordered details
	public List<ProductsOrderedDTO> getAllProductsOrdered() {

		List<ProductsOrdered> productsOrderedList = productsOrderedRepo.findAll();
		List<ProductsOrderedDTO> productsOrderedDTOList = new ArrayList<>();

		if (!productsOrderedList.isEmpty()) {
			for (ProductsOrdered productsOrdered : productsOrderedList) {
				ProductsOrderedDTO productsOrderedDTO = ProductsOrderedDTO.valueOf(productsOrdered);
				productsOrderedDTOList.add(productsOrderedDTO);
			}
		}

		logger.info("Order details : {}", productsOrderedDTOList);
		return productsOrderedDTOList;
	}

	// Fetch specific products ordered details
	public List<ProductsOrderedDTO> getSpecificProductsOrdered(int prodId) {
		
		List<ProductsOrderedDTO> productsOrderedDTOList = new ArrayList<>();
		List<ProductsOrdered> productsOrderedList = productsOrderedRepo.findByProductsOrderedKeyProdId(prodId);
		
		if (!productsOrderedList.isEmpty()) {
			for (ProductsOrdered productsOrdered : productsOrderedList) {
				ProductsOrderedDTO productsOrderedDTO = ProductsOrderedDTO.valueOf(productsOrdered);
				productsOrderedDTOList.add(productsOrderedDTO);
			}
		}
		
		logger.info("Order details : {}", prodId);
		return productsOrderedDTOList;
	}
	
	// Creating new products ordered
	public void createProductsOrdered(ProductsOrderedDTO productsOrderedDTO) {
		logger.info("Creation request for customer {}", productsOrderedDTO);
		ProductsOrdered productsOrdered = productsOrderedDTO.createEntity();
		productsOrderedRepo.save(productsOrdered);
	}

}
