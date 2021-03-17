package com.infosys.project.Order.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products_ordered")
public class ProductsOrdered {
	
	@EmbeddedId
	ProductsOrderedKey productsOrderedKey;
	@Column(name = "SELLERID", nullable = false)
	Integer sellerId;
	@Column(name = "QUANTITY", nullable = false)
	Integer quantity;
	
	public ProductsOrderedKey getProductsOrderedKey() {
		return productsOrderedKey;
	}
	public void setProductsOrderedKey(ProductsOrderedKey productsOrderedKey) {
		this.productsOrderedKey = productsOrderedKey;
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

}
