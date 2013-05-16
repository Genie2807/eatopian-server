package com.eatopian.entity;

public class Account {

	/**
	 * 
	 */
	private enum Type {
		restaurantAccount, userAccount, adminAccount;
	}

	private enum Status {
		active, inactive;
	}
	
	private String accountEmail;
	private String accountPassword;
	private Type accountType;
	private Status accountStatus;

	
	
	// Getters/Setters
	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public Type getAccountType() {
		return accountType;
	}

	public void setAccountType(Type accountType) {
		this.accountType = accountType;
	}

	public Status getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Status accountStatus) {
		this.accountStatus = accountStatus;
	}
}
