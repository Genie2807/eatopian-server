package com.eatopian.recommendation;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

public interface DAO {
	
	Map<String, Integer> getIngredientMap();
	
	Map<String, Integer> getTasteMap();
	
	Map<String, Integer> getCookingMap();
	
	Dish getDish(ObjectId dishID);
	
	List<Dish> getAllDishes();
	
	Map<String, Double> getDishSimilarity(ObjectId dishId);
	
	
	boolean addDish(Dish dish);
	
	boolean addIngredientTag(String tagName);
	
	boolean addTasteTag(String tagName);
	
	boolean addCookingTag(String tagName);
	
	boolean addDishSimilarity(ObjectId dishID, Map<String, Double> map);
	
}
