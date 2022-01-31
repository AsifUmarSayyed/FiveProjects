package com.baliraja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baliraja.dao.CategoryDao;
import com.baliraja.entity.Category;

@Service
public class CategoryServices {
	
	@Autowired
	public CategoryDao categoryDao;
	
	public Optional<Category> getCategoryById(Integer id) {
		return categoryDao.findById(id);
	}
	
	public Iterable<Category> getAllCategories(Category category) {
		return categoryDao.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryDao.save(category);
	}
	
	public Category updateCategory(Category category) {
		Optional<Category> m = categoryDao.findById(category.getId());
		Category m2 = m.get();
		m2 = category;
		return categoryDao.save(m2);
	}
}
