package com.eatopian.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class User {

	// User profile
	private long userID;
	private String userFirstName;
	private String userLastName;
	private String userPhone;

	private Account userAccount;
	private Address userAddress;

	// Store user transactions by date
	private HashMap<Date, ArrayList<Transaction>> userTransactionList;
	
	// Store user credit card
	private ArrayList<CreditCard> userCreditCardList;
	
	


	// Getters/Setters
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Account getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Account userAccount) {
		this.userAccount = userAccount;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public HashMap<Date, ArrayList<Transaction>> getUserTransactions() {
		return userTransactionList;
	}
	
	public ArrayList<CreditCard> getUserCreditCardList() {
		return userCreditCardList;
	}
	
}
