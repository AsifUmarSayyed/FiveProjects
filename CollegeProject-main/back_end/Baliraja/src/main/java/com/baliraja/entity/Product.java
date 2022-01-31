package com.baliraja.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "product")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "arrival")
	private String arrival;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "offer")
	private Integer offer;
		
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "code")
	private Integer code;
	
	@Column(name = "additional_information")
	private String additional_information;
	
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "updated_date")
	private Date updated_date;
	
	@Column(name = "clicks")
	private Integer clicks;	
	
	@Column(name = "specification_1")
	private String specification_1;
	
	@Column(name = "specification_2")
	private String specification_2;
	
	@Column(name = "specification_3")
	private String specification_3;
	
	@Column(name = "specification_4")
	private String specification_4;
	
	@Column(name = "specification_5")
	private String specification_5;
	
	@Column(name = "specification_6")
	private String specification_6;
	
	@Column(name = "specification_7")
	private String specification_7;
	
	@Column(name = "specification_8")
	private String specification_8;
	
	@Column(name = "specification_9")
	private String specification_9;
	
	@Column(name = "specification_10")
	private String specification_10;
	
	@Column(name = "description_1")
	private String description_1;
	
	@Column(name = "description_2")
	private String description_2;
	
	@Column(name = "description_3")
	private String description_3;
	
	@Column(name = "description_4")
	private String description_4;
	
	@Column(name = "description_5")
	private String description_5;
	
	@Column(name = "description_6")
	private String description_6;
	
	@Column(name = "description_7")
	private String description_7;
	
	@Column(name = "description_8")
	private String description_8;
	
	@Column(name = "description_9")
	private String description_9;
	
	@Column(name = "description_10")
	private String description_10;
		
	@Column(name = "business_id")
	private Integer businessId;
	
	@Column(name = "category_id")
	private Integer categoryId;
	
	@OneToMany(mappedBy = "product")
	private List<ProductImage> productImages;
	

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getAdditional_information() {
		return additional_information;
	}

	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public Integer getOffer() {
		return offer;
	}

	public void setOffer(Integer offer) {
		this.offer = offer;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public String getSpecification_1() {
		return specification_1;
	}

	public void setSpecification_1(String specification_1) {
		this.specification_1 = specification_1;
	}

	public String getSpecification_2() {
		return specification_2;
	}

	public void setSpecification_2(String specification_2) {
		this.specification_2 = specification_2;
	}

	public String getSpecification_3() {
		return specification_3;
	}

	public void setSpecification_3(String specification_3) {
		this.specification_3 = specification_3;
	}

	public String getSpecification_4() {
		return specification_4;
	}

	public void setSpecification_4(String specification_4) {
		this.specification_4 = specification_4;
	}

	public String getSpecification_5() {
		return specification_5;
	}

	public void setSpecification_5(String specification_5) {
		this.specification_5 = specification_5;
	}

	public String getSpecification_6() {
		return specification_6;
	}

	public void setSpecification_6(String specification_6) {
		this.specification_6 = specification_6;
	}

	public String getSpecification_7() {
		return specification_7;
	}

	public void setSpecification_7(String specification_7) {
		this.specification_7 = specification_7;
	}

	public String getSpecification_8() {
		return specification_8;
	}

	public void setSpecification_8(String specification_8) {
		this.specification_8 = specification_8;
	}

	public String getSpecification_9() {
		return specification_9;
	}

	public void setSpecification_9(String specification_9) {
		this.specification_9 = specification_9;
	}

	public String getSpecification_10() {
		return specification_10;
	}

	public void setSpecification_10(String specification_10) {
		this.specification_10 = specification_10;
	}

	public String getDescription_1() {
		return description_1;
	}

	public void setDescription_1(String description_1) {
		this.description_1 = description_1;
	}

	public String getDescription_2() {
		return description_2;
	}

	public void setDescription_2(String description_2) {
		this.description_2 = description_2;
	}

	public String getDescription_3() {
		return description_3;
	}

	public void setDescription_3(String description_3) {
		this.description_3 = description_3;
	}

	public String getDescription_4() {
		return description_4;
	}

	public void setDescription_4(String description_4) {
		this.description_4 = description_4;
	}

	public String getDescription_5() {
		return description_5;
	}

	public void setDescription_5(String description_5) {
		this.description_5 = description_5;
	}

	public String getDescription_6() {
		return description_6;
	}

	public void setDescription_6(String description_6) {
		this.description_6 = description_6;
	}

	public String getDescription_7() {
		return description_7;
	}

	public void setDescription_7(String description_7) {
		this.description_7 = description_7;
	}

	public String getDescription_8() {
		return description_8;
	}

	public void setDescription_8(String description_8) {
		this.description_8 = description_8;
	}

	public String getDescription_9() {
		return description_9;
	}

	public void setDescription_9(String description_9) {
		this.description_9 = description_9;
	}

	public String getDescription_10() {
		return description_10;
	}

	public void setDescription_10(String description_10) {
		this.description_10 = description_10;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}


	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	

}
