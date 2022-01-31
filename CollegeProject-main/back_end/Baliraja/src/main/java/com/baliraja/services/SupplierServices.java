package com.baliraja.services;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.baliraja.dao.SupplierDao;
import com.baliraja.dao.SessionLoggerDao;
import com.baliraja.dto.SupplierLoginDto;
import com.baliraja.entity.SessionLogger;
import com.baliraja.entity.Suppliers;

@Transactional
@Service
public class SupplierServices {
	

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	SessionLoggerDao sessionLoggerDao;
	
	SessionLogger sessionLogger;
	
	SupplierLoginDto supplierLoginDto;

	public SupplierLoginDto login(String emailId, String password) {
		try {
			Suppliers supplier = supplierDao.findByEmailAndPassword(emailId, password);
			HttpSession session;
			HttpServletRequest req= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			if(supplier.getId() != null) {
				session= req.getSession(true);
				session.setMaxInactiveInterval(7*60);
				session.setAttribute("supplier", supplier.getId());
				sessionLogger = new SessionLogger(session.getId(), supplier.getId());
				sessionLoggerDao.save(sessionLogger);
				supplierLoginDto = new SupplierLoginDto(session.getId(), supplier);
				}
		}catch(Exception ex) {
			supplierLoginDto = new SupplierLoginDto("Invalid", new Suppliers());
			ex.printStackTrace();
		}
		return supplierLoginDto;
	}
	
	public Optional<Suppliers> getSupplierById(Integer id) {
		return supplierDao.findById(id);
	}
	
	public Iterable<Suppliers> getAllSuppliers(Suppliers suppliers) {
		return supplierDao.findAll();
	}
	
	public Suppliers createSupplier(Suppliers suppliers){
		return supplierDao.save(suppliers);
	}
	
	public Suppliers updateSupplier(String sessionId, Suppliers supplier) {
		Integer supplierId = getSupplierBySession(sessionId).getId();
		supplier.setId(supplierId);
		return supplierDao.save(supplier);
	}
	
	//Session
	public Suppliers getSupplierBySession(String sessionId) {
		Suppliers supplier = new Suppliers();
		try {
			Optional<SessionLogger> optionalSessionLogger = sessionLoggerDao.findBySessionId(sessionId);
			Integer supplierId = optionalSessionLogger.get().getSessionAttribute();
			Optional<Suppliers> optionalSupplier =  supplierDao.findById(supplierId);
			supplier = optionalSupplier.get();
		} catch (Exception e) {
			supplier.setFull_name("Session Expired");
		}
		return supplier;
	}
	 
	public Boolean logoutSupplier(String sessionId) {
		Optional<SessionLogger> sessionLogger = sessionLoggerDao.findBySessionId(sessionId);
		if(sessionLogger.isPresent()) {
			sessionLoggerDao.delete(sessionLogger.get());
		}
		return true;
	}
}
