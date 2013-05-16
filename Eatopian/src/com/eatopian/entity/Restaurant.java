package com.eatopian.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
		
	private long restaurantID;
	private String restaurantName;
	private String restaurantPhone;
	private String restaurantFax;
	private String restaurantWebsite;
	private Account restaurantAccount;
	private Address restaurantAddress;
	
//	private String restaurantManagerFirstName;
//	private String restaurantManagerLastName;
//	private String restaurantManagerPhone;
	
	
	private HashMap<Date, ArrayList<Transaction>> restaurantTransactionList;
	private Menu restaurantMenu;
	 
}
