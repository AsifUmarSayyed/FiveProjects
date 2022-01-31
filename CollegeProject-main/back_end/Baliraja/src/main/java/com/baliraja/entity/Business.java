package com.baliraja.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "business")
public class Business implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "organisation_type")
	private String organisationType;
	
	@Column(name = "ownershipType")
	private String ownershipType;
	 

	@Column(name = "businessType")
	private String businessType;
	
	@Column(name = "business_email")
	private String businessEmail;
	
	@Column(name = "website_link")
	private String websiteLink;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "profile_views")
	private Integer profileViews;
	
	@Column(name = "year_of_establishment")
	private Date yearOfEstablishment;
		    
	@Column(name = "GST")
	private String gst;
	
	@Column(name = "PAN")
	private String pan;
	
	@Column(name = "CIN")
	private String cin;
	
	@Column(name = "DGFT")
	private String dgft;
	
	
//	@JsonBackReference
//	@OneToMany(mappedBy = "business")
//	private List<Product> product;

	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "supplier_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY )
	private Suppliers supplier;

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

	public String getOrganisationType() {
		return organisationType;
	}

	public void setOrganisationType(String organisationType) {
		this.organisationType = organisationType;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessEmail() {
		return businessEmail;
	}

	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProfileViews() {
		return profileViews;
	}

	public void setProfileViews(Integer profileViews) {
		this.profileViews = profileViews;
	}

	public Date getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(Date yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getDgft() {
		return dgft;
	}

	public void setDgft(String dgft) {
		this.dgft = dgft;
	}

	public Suppliers getSupplier() {
		return supplier;
	}

	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
	}
	
	
	

}
