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

import com.baliraja.entity.Category;
import com.baliraja.services.CategoryServices;

@RestController
@RequestMapping(value = "category")
public class CategoryController {
	
	@Autowired
	CategoryServices categoryService;
	
	@GetMapping("getCategoryById/{id}")
	public Optional<Category> getCategoryById(@PathVariable("id") Integer id) {
		return categoryService.getCategoryById(id);
	}
	
	@GetMapping("getAllCategories")
	public Iterable<Category> getCategories(Category Category) {
		return categoryService.getAllCategories(Category);
	}
	
	@PostMapping("createCategory")
	public Category createCategory(@RequestBody Category Category) {
		return categoryService.createCategory(Category);
	}
	
	@PutMapping("updateCategory")
	public Category updateCategory(@RequestBody Category Category) {
		return categoryService.updateCategory(Category);
	}
}
