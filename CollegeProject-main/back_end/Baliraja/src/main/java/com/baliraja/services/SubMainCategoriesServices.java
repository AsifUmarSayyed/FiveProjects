package com.baliraja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baliraja.dao.SubMainCategoriesDao;
import com.baliraja.entity.SubMainCategory;

@Service
public class SubMainCategoriesServices {
	
	@Autowired
	SubMainCategoriesDao subMainCategoriesDao;
	
	public Optional<SubMainCategory> getSubMainCategoryById(Integer id) {
		return subMainCategoriesDao.findById(id);
	}
	
	public Iterable<SubMainCategory> getAllSubMainCategories(SubMainCategory subMainCategory) {
		return subMainCategoriesDao.findAll();
	}
	
	public SubMainCategory createSubMainCategory(SubMainCategory subMainCategory) {
		return subMainCategoriesDao.save(subMainCategory);
	}
	
	public SubMainCategory updateSubMainCategory(SubMainCategory subMainCategory) {
		Optional<SubMainCategory> m = subMainCategoriesDao.findById(subMainCategory.getId());
		SubMainCategory m2 = m.get();
		m2 = subMainCategory;
		return subMainCategoriesDao.save(m2);
	}
}
