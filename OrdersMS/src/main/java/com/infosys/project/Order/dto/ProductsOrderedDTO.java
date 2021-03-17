package com.infosys.project.Order.dto;

import com.infosys.project.Order.entity.ProductsOrdered;
import com.infosys.project.Order.entity.ProductsOrderedKey;

public class ProductsOrderedDTO {
	
	Integer buyerId;
	Integer prodId;
	Integer sellerId;
	Integer quantity;

	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	// Converts Entity into DTO
	public static ProductsOrderedDTO valueOf(ProductsOrdered productsOrdered) {

		ProductsOrderedDTO productsOrderedDTO = new ProductsOrderedDTO();

		productsOrderedDTO.setBuyerId(productsOrdered.getProductsOrderedKey().getBuyerId());
		productsOrderedDTO.setProdId(productsOrdered.getProductsOrderedKey().getProdId());
		productsOrderedDTO.setSellerId(productsOrdered.getSellerId());
		productsOrderedDTO.setQuantity(productsOrdered.getQuantity());

		return productsOrderedDTO;
	}

	// Converts DTO into Entity
	public ProductsOrdered createEntity() {

		ProductsOrdered productsOrdered = new ProductsOrdered();
		
		ProductsOrderedKey productsOrderedKey = new ProductsOrderedKey();
		productsOrderedKey.setBuyerId(this.buyerId);
		productsOrderedKey.setProdId(this.prodId);
		
		productsOrdered.setProductsOrderedKey(productsOrderedKey);
		productsOrdered.setSellerId(this.getSellerId());
		productsOrdered.setQuantity(this.getQuantity());

		return productsOrdered;
	}

}
