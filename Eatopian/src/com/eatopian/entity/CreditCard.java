package com.eatopian.entity;

public class CreditCard {
	
	private enum Type {
		VISA, MasterCard;
	}
	
	private Type cardType;
	private int cardNumber;
	private String cardHolderFirstName;
	private String cardHolderLastName;
	private String cardExpirationDate;
	private int cardSecurityCode;
	
	
		
	// Getters/Setters
	public Type getCardType() {
		return cardType;
	}
	public void setCardType(Type cardType) {
		this.cardType = cardType;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderFirstName() {
		return cardHolderFirstName;
	}
	public void setCardHolderFirstName(String cardHolderFirstName) {
		this.cardHolderFirstName = cardHolderFirstName;
	}
	public String getCardHolderLastName() {
		return cardHolderLastName;
	}
	public void setCardHolderLastName(String cardHolderLastName) {
		this.cardHolderLastName = cardHolderLastName;
	}
	public String getCardExpirationDate() {
		return cardExpirationDate;
	}
	public void setCardExpirationDate(String cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}
	public int getCardSecurityCode() {
		return cardSecurityCode;
	}
	public void setCardSecurityCode(int cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}
	
}
