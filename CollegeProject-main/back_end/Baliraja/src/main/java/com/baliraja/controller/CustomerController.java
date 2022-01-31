package com.baliraja.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baliraja.entity.Customer;
import com.baliraja.services.CustomerServices;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
	@Autowired
	CustomerServices customerServices;
	
	@GetMapping("getAllCustomers")
	public Iterable<Customer> getAllCustomer(Customer customer) {
		return customerServices.getAllCustomers(customer);
	}
	
	@GetMapping("getCustomerById/{id}")
	public Optional<Customer> getCustomerById(@PathVariable Integer id) {
		return customerServices.getCustomerByID(id);
	}
	
	@PostMapping("createCustomer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerServices.createCustomer(customer);
	}
	
	@PutMapping("updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerServices.updateCustomer(customer);
	}
	
	@GetMapping("customerLogin/{mobileNumber}")
	public Map<String, String> customerLogin(@PathVariable("mobileNumber") Long mobileNumber) {
		return customerServices.customerLogin(mobileNumber);
	}
}
