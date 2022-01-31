package com.baliraja.dto;

import java.io.Serializable;

import com.baliraja.entity.Suppliers;

public class SupplierLoginDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private Suppliers supplier;
	
	public SupplierLoginDto(String sessionId, Suppliers suppliers){
		this.sessionId = sessionId;
		this.supplier = suppliers;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public Suppliers getSupplier() {
		return supplier;
	}
	
}
