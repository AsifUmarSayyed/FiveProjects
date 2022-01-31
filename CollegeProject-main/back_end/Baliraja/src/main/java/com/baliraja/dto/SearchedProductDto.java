package com.baliraja.dto;


public class SearchedProductDto {
	private Integer id;
	private String name;
	private String specification_1;
	private String specification_2;
	private String specification_3;
	private String specification_4;
	private String description_1;
	private String description_2;
	private String description_3;
	private String description_4;
	private Integer categorie;
	private byte[] image;
	private Integer businessId;
	private String additionalDescription;
	private Integer length;
	

	
	public SearchedProductDto(Integer id, String name, String specification_1,
			String specification_2, String specification_3, String specification_4, String description_1,
			String description_2, String description_3, String description_4,
			Integer categorie, byte[] image, Integer businessId, String additionalDescription) {
		super();
		this.id = id;
		this.name = name;
		this.specification_1 = specification_1;
		this.specification_2 = specification_2;
		this.specification_3 = specification_3;
		this.specification_4 = specification_4;
		this.description_1 = description_1;
		this.description_2 = description_2;
		this.description_3 = description_3;
		this.description_4 = description_4;
		this.categorie = categorie;
		this.image = image;
		this.businessId = businessId;
		this.additionalDescription = additionalDescription;
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
	
	
	public Integer getCategorie() {
		return categorie;
	}

	public void setCategorie(Integer categorie) {
		this.categorie = categorie;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public Integer getBusinessId() {
		return businessId;
	}
	
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	
	public String getAdditionalDescription() {
		return additionalDescription;
	}
	
	public void setAdditionalDescription(String additionalDescription) {
		this.additionalDescription = additionalDescription;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
}
