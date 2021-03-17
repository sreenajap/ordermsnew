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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.Order.dto.OrderDTO;
import com.infosys.project.Order.entity.OrderStatus;
import com.infosys.project.Order.service.OrderService;


@RestController
@CrossOrigin
@RequestMapping(value="/orders")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderService orderService;
	
	
	
	
	@GetMapping(value = "/{orderId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO getSpecificOrders(@PathVariable Integer orderId) {
		logger.info("Fetching details of order {}",orderId);
		return orderService.getSpecificOrder(orderId);
	}
	
	@GetMapping(value = "/findbybuyerid",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getOrdersByBuyerId(@RequestParam(value="buyerid", required = true) Integer buyerId) {
		logger.info("Fetching details of order of {}",buyerId);
		return orderService.getOrdersByBuyerId(buyerId);
	}
	@GetMapping(value = "",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getAllOrders() {
		logger.info("Fetching all orders");
		return orderService.getAllOrders();
	}
	
	@PostMapping(value = "/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createOrders(@RequestBody OrderDTO orderDTO) {
		logger.info("Creation request for order {}", orderDTO);
		orderService.createOrder(orderDTO);
	}
	
	@PostMapping(value = "/{orderId}/update",  consumes = MediaType.APPLICATION_JSON_VALUE) 
	public void setOrderStatus(@PathVariable Integer orderId, @RequestParam(value = "orderstatus", required = true) OrderStatus orderStatus){
		logger.info("Update request for order status of ", orderId);
		orderService.updateOrderStatus(orderId, orderStatus);
		logger.info("Order status updated");
	}

}
