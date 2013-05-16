package com.eatopian.entity;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;


public class Transaction {
	
	private long transactionID;
	
	private long restaurantID;
	private long userID;
	private Date transactionDate;
	private Time transactionTime;
	private double taxRate;
	private double subtotal;
	private ArrayList<Order> transactionOrderList;
	
	
	
	
	public long getTransactionID() {
		return transactionID;
	}

	public long getRestaurantID() {
		return restaurantID;
	}

	public long getUserID() {
		return userID;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public Time getTransactionTime() {
		return transactionTime;
	}

	public double getTax() {
		return this.getSubtotal() * this.getTaxRate();
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public double getSubtotal() {
		return subtotal;
	}

	public ArrayList<Order> getTransactionOrderList() {
		return transactionOrderList;
	}
	
	public void addOrder(Order order){
		this.transactionOrderList.add(order);
	}
	
}
