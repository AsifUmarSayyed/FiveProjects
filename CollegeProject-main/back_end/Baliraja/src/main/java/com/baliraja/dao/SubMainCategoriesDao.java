package com.baliraja.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.SubMainCategory;

@Repository
public interface SubMainCategoriesDao extends CrudRepository<SubMainCategory, Integer>{

}
