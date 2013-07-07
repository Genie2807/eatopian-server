package com.eatopian.entity;

import java.util.Date;

public class Token {
	
	private String token;
	private Date lastModified;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
