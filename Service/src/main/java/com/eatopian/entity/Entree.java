package com.eatopian.entity;
import java.util.ArrayList;

public class Entree {
	
	private String entreeName;
	private ArrayList<Dish> dishes;
	private String entreeDescription;
	
	public String getEntreeName() {
		return entreeName;
	}
	public void setEntreeName(String entreeName) {
		this.entreeName = entreeName;
	}
	public ArrayList<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(ArrayList<Dish> dishes) {
		this.dishes = dishes;
	}
	public String getEntreeDescription() {
		return entreeDescription;
	}
	public void setEntreeDescription(String entreeDescription) {
		this.entreeDescription = entreeDescription;
	}	
}
