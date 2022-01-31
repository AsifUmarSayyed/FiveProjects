package com.baliraja.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.baliraja.entity.SessionLogger;

public interface SessionLoggerDao extends CrudRepository<SessionLogger , Integer>{

	Optional<SessionLogger> findBySessionId(String sessionId);
//	public Integer findBySessionAttribute(String s)
}
