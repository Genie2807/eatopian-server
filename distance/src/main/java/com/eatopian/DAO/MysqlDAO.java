package com.eatopian.DAO;

import java.util.List;

import com.eatopian.entity.Address;
import com.eatopian.entity.Restaurant;

public interface MysqlDAO {
	
	public void insert(Restaurant restaurant);
	public List<Restaurant> findNearRestaurant(Address address, int precision);
}
