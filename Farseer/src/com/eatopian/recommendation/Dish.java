package com.eatopian.recommendation;

import java.util.List;

import org.bson.types.ObjectId;

public class Dish {

	private ObjectId dishID;
	private String dishName, dishChineseName, restaurantName, restaurantChineseName;
	private List ingredientTagList, tasteTagList, cookingTagList;

	public Dish() {
		this.dishID = null;
	}

	public Dish(ObjectId objectId, String dName, String dCName) {
		this.dishID = objectId;
		this.dishName = dName;
		this.dishChineseName = dCName;
	}

	public ObjectId getDishID() {
		return dishID;
	}

	public void setDishID(ObjectId dishID) {
		this.dishID = dishID;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishChineseName() {
		return dishChineseName;
	}

	public void setDishChineseName(String dishChineseName) {
		this.dishChineseName = dishChineseName;
	}

	public List getIngredientTagList() {
		return ingredientTagList;
	}

	public void setIngredientTagList(List ingredientTagList) {
		this.ingredientTagList = ingredientTagList;
	}

	public List getTasteTagList() {
		return tasteTagList;
	}

	public void setTasteTagList(List tasteTagList) {
		this.tasteTagList = tasteTagList;
	}

	public List getCookingTagList() {
		return cookingTagList;
	}

	public void setCookingTagList(List cookingTagList) {
		this.cookingTagList = cookingTagList;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantChineseName() {
		return restaurantChineseName;
	}

	public void setRestaurantChineseName(String restaurantChineseName) {
		this.restaurantChineseName = restaurantChineseName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.restaurantName);
		sb.append("\n");
		sb.append(this.restaurantChineseName);
		sb.append("\n");
		sb.append(this.dishName);
		sb.append("\n");
		sb.append(this.dishChineseName);
		sb.append("\n");
		sb.append(this.getIngredientTagList());
		sb.append("\n");
		sb.append(this.getTasteTagList());
		sb.append("\n");
		sb.append(this.getCookingTagList());
		sb.append("\n\n");
		return sb.toString();
	}
}
