package com.eatopian.entity;

public class Order {
	
	private long orderID;
	private Item orderItem;
	private int orderQuantity;
	
	
	
	public double getOrderSubtotal(){
		return this.orderItem.getItem_Price() * this.orderQuantity;
	}
	
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public Item getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(Item orderItem) {
		this.orderItem = orderItem;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
}
