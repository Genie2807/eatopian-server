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

    private String restaurantName;
    private String restaurantChineseName;

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

    public Dish(String dID, String dishName, String dishChineseName) {
        this.dishID = dID;
        this.dishName = dishName;
        this.dishChineseName = dishChineseName;
    }

    public Dish() {
        this.dishID = null;
    }

    public String getDishID() {
        return dishID;
    }

    public void setDishID(String dishID) {
        this.dishID = dishID;
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
        StringBuilder sb=new StringBuilder();
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