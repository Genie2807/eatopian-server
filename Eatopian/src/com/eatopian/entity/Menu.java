package com.eatopian.entity;

import java.util.*;

public class Menu {
	
	
	/*
	 *  Menu:
	 *  	Entry 1:
	 *  		Item 1, Item 2, Item 3...
	 *  	Entry 2:
	 *  		Item 1, Item 2, Item 3...
	 *  	...
	 */
	private HashMap<String, ArrayList<Item>> Menu_List;

	
	
	
	public HashMap<String, ArrayList<Item>> getMenu_List() {
		return Menu_List;
	}

	public void setMenu_List(HashMap<String, ArrayList<Item>> menu_List) {
		Menu_List = menu_List;
	}	
}
