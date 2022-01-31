package com.baliraja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baliraja.dao.BusinessDao;
import com.baliraja.dao.SupplierDao;
import com.baliraja.entity.Business;
import com.baliraja.entity.Suppliers;

@Service
public class BusinessServices {

	@Autowired
	public BusinessDao businessDao;
	
	@Autowired
	public SupplierDao supplierDao;
	
	@Autowired
	public SupplierServices supplierServcies;
	
	public Business createBusiness(String sessionId, Business business) {
		Suppliers supplier = supplierServcies.getSupplierBySession(sessionId);
		business.setSupplier(supplier);
		return businessDao.save(business);
	}
	
	public Business updateBusiness(String sessionId, Business business) {
		Suppliers supplier = supplierServcies.getSupplierBySession(sessionId);
		business.setSupplier(supplier);
		return businessDao.save(business);
	}
	
	public Suppliers getSupplierByBusiness(String businessId) {
		int intBusinessId = Integer.valueOf(businessId);
		Optional<Business> business = businessDao.findById(intBusinessId );
		Integer supplierId = business.get().getSupplier().getId();
		Optional<Suppliers> supplier = supplierServcies.getSupplierById(supplierId);
		return supplier.get();
	}
}

