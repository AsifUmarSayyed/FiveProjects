package com.baliraja.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baliraja.entity.SubMainCategory;
import com.baliraja.services.SubMainCategoriesServices;

@RestController
@RequestMapping(value = "subCategory")
public class SubMainCategoriesController {
	
	@Autowired
	SubMainCategoriesServices subMainCategoriesServices;
	
	@GetMapping("getSubMainCategoryById/{id}")
	public Optional<SubMainCategory> getSubMainCategoryById(@PathVariable("id") Integer id) {
		return subMainCategoriesServices.getSubMainCategoryById(id);
	}
	
	@GetMapping("getAllSubMainCategories")
	public Iterable<SubMainCategory> getAllSubMainCategories(SubMainCategory subMainCategory) {
		return subMainCategoriesServices.getAllSubMainCategories(subMainCategory);
	}
	
	@PostMapping("createSubMainCategory")
	public SubMainCategory createSubMainCategory(@RequestBody SubMainCategory subMainCategory) {
		return subMainCategoriesServices.createSubMainCategory(subMainCategory);
	}
	
	@PutMapping("updateSubMainCategory")
	public SubMainCategory updateSubMainCategory(@RequestBody SubMainCategory subMainCategory) {
		return subMainCategoriesServices.updateSubMainCategory(subMainCategory);
	}
}
