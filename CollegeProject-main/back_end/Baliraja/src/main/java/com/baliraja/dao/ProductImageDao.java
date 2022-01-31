package com.baliraja.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.ProductImage;

@Repository
public interface ProductImageDao extends CrudRepository<ProductImage, Integer>{

	public ProductImage findByProductId(Integer productId);
	
}
