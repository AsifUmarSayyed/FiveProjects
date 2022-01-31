package com.baliraja.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Suppliers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "phone_number")
	private Long phone_number;
	
	@Column(name = "mobile_number")
	private Long mobile_number;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email_optional")
	private String email_optional;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "area_street")
	private String area_street;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "taluka")
	private String taluka;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private Integer pincode;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "profile_views")
	private Integer profileViews;
	
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private List<Business> business;
	
	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public Long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail_optional() {
		return email_optional;
	}
	public void setEmail_optional(String email_optional) {
		this.email_optional = email_optional;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea_street() {
		return area_street;
	}
	public void setArea_street(String area_street) {
		this.area_street = area_street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTaluka() {
		return taluka;
	}
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	/**
	 * @return the profileViews
	 */
	public Integer getProfileViews() {
		return profileViews;
	}
	/**
	 * @param profileViews the profileViews to set
	 */
	public void setProfileViews(Integer profileViews) {
		this.profileViews = profileViews;
	}
	public List<Business> getBusiness() {
		return business;
	}
	public void setBusiness(List<Business> business) {
		this.business = business;
	}
	
}
