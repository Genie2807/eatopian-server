package com.eatopian.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="user") 
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	@XmlElement
	protected String username;

	@XmlElement
	protected String password;


	public String getUsername() { return this.username; }

	public void setUsername(String username} { this.username = name; }

	public String getPassword() { return this.password; }

	public void setPassword(String password} { this.password = password; }
}