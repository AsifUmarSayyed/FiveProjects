package com.baliraja.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "main_category")
public class MainCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "mainCategory", cascade = CascadeType.ALL)
	private List<SubMainCategory> subMainCategory;


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

	public List<SubMainCategory> getSubMainCategory() {
		return subMainCategory;
	}

	public void setSubMainCategory(List<SubMainCategory> subMainCategory) {
		this.subMainCategory = subMainCategory;
	}


}
