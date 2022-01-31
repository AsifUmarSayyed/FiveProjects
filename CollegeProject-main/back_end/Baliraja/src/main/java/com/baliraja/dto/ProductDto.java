package com.baliraja.dto;

import java.sql.Date;

public class ProductDto {
	private String name;
	private Integer id;
	private Integer code;
	private String brand;
	private float price;
	private String arrival;
	private String unit;
	private Integer categoryId;
	private Date created_date;
	private Integer clicks;
	private Integer offer;
	
	public ProductDto(String name, Integer id, Integer code, String brand, float price, String arrival, String unit,
			Date created_date, Integer clicks,Integer offer) {
		super();
		this.name = name;
		this.id = id;
		this.code = code;
		this.brand = brand;
		this.price = price;
		this.arrival = arrival;
		this.unit = unit;
		this.created_date = created_date; 
		this.clicks = clicks;
		this.offer = offer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Integer getOffer() {
		return offer;
	}

	public void setOffer(Integer offer) {
		this.offer = offer;
	}

	
}
