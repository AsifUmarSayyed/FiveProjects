package com.baliraja.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer>{

	public Customer findByMobileNumber(Long mobileNumber);
}
