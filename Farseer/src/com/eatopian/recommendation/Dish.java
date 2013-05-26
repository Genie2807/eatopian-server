package com.eatopian.recommendation;

import java.util.ArrayList;

public class Dish {

	private String dishID, dishName, dishChineseName;
	private ArrayList<String> ingredientTagList, tasteTagList, cookingTagList;

	public ArrayList<String> getIngredientTagList() {
		return ingredientTagList;
	}

	public void setIngredientTagList(ArrayList<String> ingredientTagList) {
		this.ingredientTagList = ingredientTagList;
	}

	public ArrayList<String> getTasteTagList() {
		return tasteTagList;
	}

	public void setTasteTagList(ArrayList<String> tasteTagList) {
		this.tasteTagList = tasteTagList;
	}

	public ArrayList<String> getCookingTagList() {
		return cookingTagList;
	}

	public void setCookingTagList(ArrayList<String> cookingTagList) {
		this.cookingTagList = cookingTagList;
	}

	public Dish(String dID, String dName, String dCName) {
		this.dishID = dID;
		this.dishName = dishName;
		this.dishChineseName = dishChineseName;
	}
}
// {
// dishName: Sauteed Julienne Beef w/Long Horn Peppers,
// dishChineseName: 小辣椒牛肉丝,
// Ingredient: [tagID, tagID, tagID....],
// Taste: [tagID, tagID, tagID....],
// Cooking: [tagID, tagID, tagID....]
//
// $beef,pepper
// $salty,spicy
// $lunch special,stir-fry
// }