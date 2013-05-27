package com.eatopian.recommendation;

import java.util.List;

import org.bson.types.ObjectId;

public class Dish {

	private ObjectId dishID;
	private String dishName, dishChineseName;
	private List ingredientTagList, tasteTagList, cookingTagList;
	
	
	
	
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

	public Dish(ObjectId objectId, String dName, String dCName) {
		this.dishID = objectId;
		this.dishName = dishName;
		this.dishChineseName = dishChineseName;
	}
}
