package com.baliraja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baliraja.entity.Business;
import com.baliraja.entity.Suppliers;
import com.baliraja.services.BusinessServices;

@RestController
@RequestMapping(value = "business")
public class BusinessController {

	@Autowired
	BusinessServices businessServices;
	
	@PostMapping("createBusines")
	public Business createBusiness(@RequestHeader("sessionId") String sessionId, @RequestBody Business business) {
		return businessServices.createBusiness(sessionId, business);	
	}
	
	@PostMapping("updateBusiness")
	public Business updateBusiness(@RequestHeader("sessionId") String sessionId, @RequestBody Business business) {
		return businessServices.updateBusiness(sessionId, business);
	}
	
	@GetMapping("getBusinessId/{businessId}")
	public Suppliers getSupplierByBusiness(@PathVariable String businessId) {
		System.out.println("Bsiness id" + businessId);
		return businessServices.getSupplierByBusiness(businessId);
	}
}
