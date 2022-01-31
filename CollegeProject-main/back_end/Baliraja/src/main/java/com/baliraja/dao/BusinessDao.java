package com.baliraja.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baliraja.entity.Business;

@Repository
public interface BusinessDao extends CrudRepository<Business, Integer> {
}