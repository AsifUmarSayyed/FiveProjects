package com.baliraja.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

	public List<Product> findByBusinessId(Integer businessId);
	
	public List<Product> findByNameContainingIgnoreCase(String productName);
	
	
}