package com.eatopian.entity;

import java.util.Date;

public class Token {
	
	private String token;
	private Date createDate;
	
	public Token(String token){
		this.token = token;
		this.createDate = new Date();
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
