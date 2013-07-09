package com.eatopian.entity;

<<<<<<< HEAD:Service/src/main/java/com/eatopian/entity/Account.java
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="account") 
@XmlAccessorType(XmlAccessType.FIELD)
=======
>>>>>>> GBranch:Service/src/main/java/com/eatopian/entity/Account.java
public class Account {
	
	protected Integer id;
	
	protected String obfuscation;
	
	protected Token token;
	
	protected String username;

	protected String password;
	
	protected String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObfuscation() {
		return obfuscation;
	}

	public void setObfuscation(String obfuscation) {
		this.obfuscation = obfuscation;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
