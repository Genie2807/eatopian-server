package com.eatopian.entity;

import java.util.ArrayList;

public class Manager extends User {
	
	protected ArrayList<Restaurant> restaurantList;

	
	public ArrayList<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}	
}
