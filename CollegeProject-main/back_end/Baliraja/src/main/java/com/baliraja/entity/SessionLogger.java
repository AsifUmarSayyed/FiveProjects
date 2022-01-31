package com.baliraja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "session_logger")
public class SessionLogger {
	
	@Id
	@Column(name = "session_id")
	private String sessionId;
	
	@Column(name = "session_attribute")
	private Integer sessionAttribute;
	
	public SessionLogger() {
		super();
	}
	public SessionLogger(String id, int attribute){
		this.sessionId = id;
		this.sessionAttribute = attribute;
	}

	public String getSessionId() {
		return sessionId;
	}

	public Integer getSessionAttribute() {
		return sessionAttribute;
	}
	
}