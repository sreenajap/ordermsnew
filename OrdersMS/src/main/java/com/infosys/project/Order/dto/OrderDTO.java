package com.infosys.project.Order.dto;

import java.sql.Date;

import com.infosys.project.Order.entity.Order;
import com.infosys.project.Order.entity.OrderStatus;

public class OrderDTO {
	
	Integer orderId;
	Integer buyerId;
	Double amount;
	Date date;
	String address;
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
	
	// Converts Entity into DTO
	public static OrderDTO valueOf(Order order) {
		
		OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setBuyerId(order.getBuyerId());
		orderDTO.setAmount(order.getAmount());
		orderDTO.setDate(order.getDate());
		orderDTO.setAddress(order.getAddress());
		orderDTO.setStatus(order.getStatus());
		
		return orderDTO;
	}

	// Converts DTO into Entity
	public Order createEntity() {
		
		Order order = new Order();
		
		order.setBuyerId(this.buyerId);
		order.setAmount(this.amount);
		order.setDate(this.date);
		order.setAddress(this.address);
		order.setStatus(this.status);
		
		return order;
	}
	
}
