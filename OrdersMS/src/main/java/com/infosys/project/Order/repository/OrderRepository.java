package com.infosys.project.Order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.project.Order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	List<Order> getByBuyerId(Integer buyerId);
	
}
