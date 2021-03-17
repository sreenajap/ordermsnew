package com.infosys.project.Order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project.Order.dto.OrderDTO;
import com.infosys.project.Order.entity.Order;
import com.infosys.project.Order.entity.OrderStatus;
import com.infosys.project.Order.repository.OrderRepository;

@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderRepo;
	
	
	public List<OrderDTO> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		List<OrderDTO> orderDTOs = new ArrayList<>();

		for (Order order : orders) {
			OrderDTO orderDTO = OrderDTO.valueOf(order);
			orderDTOs.add(orderDTO);
		}

		logger.info("Order details : {}", orderDTOs);
		return orderDTOs;
	}
	
	public OrderDTO getSpecificOrder(int orderId) {
		OrderDTO orderDTO = null;
		Optional<Order> optOrder = orderRepo.findById(orderId);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			orderDTO = OrderDTO.valueOf(order);
		}
		logger.info("Order details : {}", orderId);
		return orderDTO;
	}
	
	public List<OrderDTO> getOrdersByBuyerId(Integer buyerId) {
		List<Order> orders = orderRepo.getByBuyerId(buyerId);
		List<OrderDTO> orderDTOs = new ArrayList<>();

		for (Order order : orders) {
			OrderDTO orderDTO = OrderDTO.valueOf(order);
			orderDTOs.add(orderDTO);
		}

		logger.info("Order details : {}", orderDTOs);
		return orderDTOs;
	}
	
	public void createOrder(OrderDTO orderDTO) {
		logger.info("Creation request for customer {}", orderDTO);
		Order order = orderDTO.createEntity();
		orderRepo.save(order);
	}
	
	public void updateOrderStatus(Integer orderId, OrderStatus orderStatus){
		logger.info("Update request for order status of ", orderId);
		Optional<Order> optOrder = orderRepo.findById(orderId);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			order.setStatus(orderStatus);
			orderRepo.save(order);
		}
		logger.info("Order status updated");
	}

}
