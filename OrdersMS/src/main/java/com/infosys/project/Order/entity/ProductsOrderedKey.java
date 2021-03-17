package com.infosys.project.Order.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ProductsOrderedKey implements Serializable{
	
	@Column(name = "BUYERID", nullable = false)
	Integer buyerId;
	@Column(name = "PRODID", nullable = false)
	Integer prodId;
	
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
	
}

