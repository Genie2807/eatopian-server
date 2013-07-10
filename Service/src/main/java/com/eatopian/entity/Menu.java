package com.eatopian.entity;

import java.util.List;

public class Menu {
	
	private List<Category> entrees;

	public List<Category> getMenu() {
		return entrees;
	}
	
	public void setMenu(List<Category> entrees) {
		this.entrees = entrees;
	}
	
}
