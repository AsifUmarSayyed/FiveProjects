package com.baliraja.dto;

public class CustomerOrder {
	private String prodcutName;
	private Integer quantity;
	private String deliveryStatus;
	private Float price;
	private Float pricePerItem;

	public String getProdcutName() {
		return prodcutName;
	}

	public void setProdcutName(String prodcutName) {
		this.prodcutName = prodcutName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(Float pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

}
