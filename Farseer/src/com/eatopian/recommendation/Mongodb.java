package com.eatopian.recommendation;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Mongodb implements DAO {
	private MongoClient mongoClient;
	private DB mongodb;

	public Mongodb() {
		try {
			mongoClient = new MongoClient("g.sj.gs");
			mongodb = mongoClient.getDB("eatopian");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public Map<String, Integer> getIngredientMap() {
		Map<String, Integer> ingredientMap = new HashMap<String, Integer>();
		int index = 0;
		DBCollection coll = mongodb.getCollection("Ingredient_Tag");
		DBCursor cursor = coll.find();
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				ingredientMap.put((String) dbObject.get("tagName"), index++);
			}
		} finally {
			cursor.close();
		}
		return ingredientMap;
	}

	@Override
	public Map<String, Integer> getTasteMap() {
		Map<String, Integer> tasteMap = new HashMap<String, Integer>();
		int index = 0;
		DBCollection coll = mongodb.getCollection("Taste_Tag");
		DBCursor cursor = coll.find();
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				tasteMap.put((String) dbObject.get("tagName"), index++);
			}
		} finally {
			cursor.close();
		}
		return tasteMap;
	}

	@Override
	public Map<String, Integer> getCookingMap() {
		Map<String, Integer> cookingMap = new HashMap<String, Integer>();
		int index = 0;
		DBCollection coll = mongodb.getCollection("CookingMap_Tag");
		DBCursor cursor = coll.find();
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				cookingMap.put((String) dbObject.get("tagName"), index++);
			}
		} finally {
			cursor.close();
		}
		return cookingMap;
	}

	@Override
	public Dish getDish(String dishID) {
		// TODO Auto-generated method stub
		Dish targetDish = null;
		DBCollection coll = mongodb.getCollection("Dish");
		BasicDBObject query = new BasicDBObject("_id", dishID);
		DBCursor cursor = coll.find(query);
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				targetDish = new Dish(dishID, (String) dbObject.get("dishName"), (String) dbObject.get("dishChineseName"));
				ArrayList<String> ingredientList = (ArrayList<String>)dbObject.get("Ingredient");
				ArrayList<String> tasteList = (ArrayList<String>)dbObject.get("Taste");
				ArrayList<String> cookingList = (ArrayList<String>)dbObject.get("Cooking");
				targetDish.setIngredientTagList(ingredientList);
				targetDish.setTasteTagList(tasteList);
				targetDish.setCookingTagList(cookingList);				
			}
		} finally {
			cursor.close();
		}	
		return targetDish;
	}
	
	@Override
	public List<Dish> getAllDishes() {
		List<Dish> dishList = new ArrayList<Dish>();
		DBCollection coll = mongodb.getCollection("Dish");
		DBCursor cursor = coll.find();
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				Dish targetDish = new Dish((String) dbObject.get("_id"), (String) dbObject.get("dishName"), (String) dbObject.get("dishChineseName"));
				ArrayList<String> ingredientList = (ArrayList<String>)dbObject.get("Ingredient");
				ArrayList<String> tasteList = (ArrayList<String>)dbObject.get("Taste");
				ArrayList<String> cookingList = (ArrayList<String>)dbObject.get("Cooking");
				targetDish.setIngredientTagList(ingredientList);
				targetDish.setTasteTagList(tasteList);
				targetDish.setCookingTagList(cookingList);
				dishList.add(targetDish);
			}
		} finally {
			cursor.close();
		}
		
		// TODO Auto-generated method stub
		return dishList;
	}

}
