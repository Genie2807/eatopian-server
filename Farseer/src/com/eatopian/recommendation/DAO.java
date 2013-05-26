package com.eatopian.recommendation;

import java.util.List;
import java.util.Map;

public interface DAO {
	
	Map<String, Integer> getIngredientMap();
	
	Map<String, Integer> getTasteMap();
	
	Map<String, Integer> getCookingMap();
	
	Dish getDish(String dishID);
	
	List<Dish> getAllDishes();
	
}
