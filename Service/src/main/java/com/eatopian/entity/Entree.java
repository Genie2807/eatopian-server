package com.eatopian.entity;
import java.util.List;

public class Entree {
	
	private String entreeName;
	private List<Dish> dishes;
	private String entreeDescription;
	
	public String getEntreeName() {
		return entreeName;
	}
	public void setEntreeName(String entreeName) {
		this.entreeName = entreeName;
	}
	public List<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	public String getEntreeDescription() {
		return entreeDescription;
	}
	public void setEntreeDescription(String entreeDescription) {
		this.entreeDescription = entreeDescription;
	}	
}
