package com.baliraja.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.baliraja.entity.Suppliers;

@Repository
public interface SupplierDao extends CrudRepository<Suppliers, Integer>{

	Suppliers findByEmailAndPassword(String emailId, String password);
}
