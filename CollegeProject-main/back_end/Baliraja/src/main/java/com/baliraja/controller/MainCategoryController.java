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

import com.baliraja.entity.MainCategory;
import com.baliraja.services.MainCategoryServices;

@RestController
@RequestMapping(value = "mainCategory")
public class MainCategoryController {
	
	@Autowired
	MainCategoryServices mainCategoryServices;
	
	@GetMapping("getMainCategoryById/{id}")
	public Optional<MainCategory> getMainCategoryById(@PathVariable("id") Integer id) {
		return mainCategoryServices.getMainCategoryById(id);
	}
	
	@GetMapping("getAllMainCategories")
	public Iterable<MainCategory> getAllMainCategories(MainCategory mainCategory) {
		return mainCategoryServices.getAllCategories(mainCategory);
	}
	
	@PostMapping("createMainCategory")
	public MainCategory createMainCategory(@RequestBody MainCategory mainCategory) {
		return mainCategoryServices.createMainCategory(mainCategory);
	}
	
	@PutMapping("updateMainCategory")
	public MainCategory updateMainCategory(@RequestBody MainCategory mainCategory) {
		return mainCategoryServices.updateCategory(mainCategory);
	}
}
