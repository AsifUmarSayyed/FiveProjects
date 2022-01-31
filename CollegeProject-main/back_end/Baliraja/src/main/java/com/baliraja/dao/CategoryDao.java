package com.baliraja.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {

}
