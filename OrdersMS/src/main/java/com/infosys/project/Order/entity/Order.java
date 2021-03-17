package com.infosys.project.Order.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "ORDERID", nullable = false)
	Integer orderId;
	@Column(name = "BUYERID", nullable = false, length = 50)
	Integer buyerId;
	@Column(name = "AMOUNT", nullable = false)
	Double amount;
	@Column(name = "DATE", nullable = false)
	Date date;
	@Column(name = "ADDRESS", nullable = false)
	String address;
	@Column(name = "STATUS", nullable = false, length = 50)
	@Enumerated(value = EnumType.STRING)
	OrderStatus status;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}
