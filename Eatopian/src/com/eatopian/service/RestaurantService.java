package com.eatopian.service;

import com.eatopian.entity.Restaurant;

public interface RestaurantService {
	void createRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int id);
}
