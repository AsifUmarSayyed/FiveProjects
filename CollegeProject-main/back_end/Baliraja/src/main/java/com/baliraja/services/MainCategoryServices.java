package com.baliraja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baliraja.dao.MainCategoryDao;
import com.baliraja.entity.MainCategory;

@Service
public class MainCategoryServices {

	@Autowired
	MainCategoryDao mainCategoryDao;
	
	public Optional<MainCategory> getMainCategoryById(Integer id) {
		return mainCategoryDao.findById(id);
	}
	
	public Iterable<MainCategory> getAllCategories(MainCategory mainCategory) {
		return mainCategoryDao.findAll();
	}
	
	public MainCategory createMainCategory(MainCategory mainCategory) {
		return mainCategoryDao.save(mainCategory);
	}
	
	public MainCategory updateCategory(MainCategory mainCategory) {
		Optional<MainCategory> m = mainCategoryDao.findById(mainCategory.getId());
		MainCategory m2 = m.get();
		m2 = mainCategory;
		return mainCategoryDao.save(m2);
	}
}
