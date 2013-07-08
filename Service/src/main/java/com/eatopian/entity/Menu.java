package com.eatopian.entity;

import java.util.List;

public class Menu {
	
	private List<Entree> entrees;

	public List<Entree> getMenu() {
		return entrees;
	}
	
	public void setMenu(List<Entree> entrees) {
		this.entrees = entrees;
	}
	
}
