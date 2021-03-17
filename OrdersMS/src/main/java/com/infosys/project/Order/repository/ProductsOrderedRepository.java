package com.infosys.project.Order.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.project.Order.entity.ProductsOrdered;
import com.infosys.project.Order.entity.ProductsOrderedKey;

@Repository
public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, ProductsOrderedKey> {
	public List<ProductsOrdered> findByProductsOrderedKeyProdId(Integer prodId);
}
