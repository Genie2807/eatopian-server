package com.eatopian.recommendation;

import java.util.ArrayList;

public class Dish {

	private String dishID;

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

    private String dishName;
    private String dishChineseName;
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

    public String getDishID() {
        return dishID;
    }

    public void setDishID(String dishID) {
        this.dishID = dishID;
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