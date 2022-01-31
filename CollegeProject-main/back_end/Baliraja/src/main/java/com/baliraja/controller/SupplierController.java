package com.baliraja.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baliraja.dto.SupplierLoginDto;
import com.baliraja.entity.Suppliers;
import com.baliraja.services.SupplierServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "supplier")
public class SupplierController{

	@Autowired
	SupplierServices supplierServices;
	
	@GetMapping("/login/{emailId}/{password}")
	public SupplierLoginDto login(@PathVariable String emailId,@PathVariable String password) {
		SupplierLoginDto supplierLoginDto = supplierServices.login(emailId, password);
		return supplierLoginDto;
	}
		
	@GetMapping("getAll")
	public Iterable<Suppliers> getAllSuppliers(Suppliers suppliers) {
		return supplierServices.getAllSuppliers(suppliers);
	}
	@GetMapping("getSupplierById/{id}")
	public Optional<Suppliers> getSupplierById(@PathVariable("id") Integer id) {
		System.out.println("Called Supplier controller --------------------------------------");
		return supplierServices.getSupplierById(id);
	}
	
	@PostMapping("createSupplier")
	public Suppliers createSupplier(@RequestBody Suppliers supplier) {
		return supplierServices.createSupplier(supplier);
	}
	
	@PutMapping("updateSupplier")
	public Suppliers updateSupplier(@RequestHeader("sessionId") String sessionId, @RequestBody Suppliers supplier) {
		return supplierServices.updateSupplier(sessionId, supplier);
	}
	
	@GetMapping("logout/{sessionId}")
	public Boolean logoutSupplier(@PathVariable("sessionId") String sessionId) {
		supplierServices.logoutSupplier(sessionId);
		return true;
	}
	
	// Session
	@GetMapping("getSupplier/{sessionId}")
	public Suppliers getSupplierBySession(@PathVariable(value="sessionId") String sessionId) {
		try {
			return supplierServices.getSupplierBySession(sessionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Suppliers();
	}
}
