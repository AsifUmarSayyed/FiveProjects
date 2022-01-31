package com.baliraja.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.ProductOrder;

@Repository
public interface OrderDao extends CrudRepository<ProductOrder, Integer>{
	List<ProductOrder> findBySupplierId(Integer id);

	List<ProductOrder> findByCustomerId(Integer id);
}
