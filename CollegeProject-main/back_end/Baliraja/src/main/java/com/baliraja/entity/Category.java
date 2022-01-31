package com.baliraja.entity;


import javax.persistence.Entity;


import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	

	@Column(name = "name")
	private String name;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sub_main_category_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private SubMainCategory subMainCategory;


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

	public SubMainCategory getSubMainCategory() {
		return subMainCategory;
	}

	public void setSubMainCategory(SubMainCategory subMainCategory) {
		this.subMainCategory = subMainCategory;
	}



}
