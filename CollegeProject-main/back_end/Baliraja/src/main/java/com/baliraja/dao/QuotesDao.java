package com.baliraja.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.Quotes;
import com.baliraja.entity.Suppliers;

@Repository
public interface QuotesDao extends CrudRepository<Quotes, Integer>{

	List<Quotes> findBySuppliers(Suppliers supplier);
}
