package com.eatopian.recommendation;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
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
		DBCollection coll = mongodb.getCollection("Cooking_Tag");
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
	public Dish getDish(ObjectId dishID) {
		// TODO Auto-generated method stub
		Dish targetDish = null;
		DBCollection coll = mongodb.getCollection("Dish");
		BasicDBObject query = new BasicDBObject("_id", dishID);
		DBCursor cursor = coll.find(query);
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				targetDish = new Dish(dishID,
						(String) dbObject.get("dishName"),
						(String) dbObject.get("dishChineseName"));
				BasicDBList ingredientList = (BasicDBList) dbObject
						.get("Ingredient");
				BasicDBList tasteList = (BasicDBList) dbObject
						.get("Taste");
				BasicDBList cookingList = (BasicDBList) dbObject
						.get("Cooking");
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
				Dish targetDish = new Dish( (ObjectId) dbObject.get("_id"),
						(String) dbObject.get("dishName"),
						(String) dbObject.get("dishChineseName"));
				BasicDBList ingredientList = (BasicDBList) dbObject
						.get("Ingredient");
				BasicDBList tasteList = (BasicDBList) dbObject
						.get("Taste");
				BasicDBList cookingList = (BasicDBList) dbObject
						.get("Cooking");
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

	@Override
	public boolean addDish(Dish dish) {
		// TODO Auto-generated method stub
		DBCollection coll = mongodb.getCollection("Dish");		
		BasicDBObject doc = new BasicDBObject("dishName", dish.getDishName())
		.append("dishChineseName", dish.getDishChineseName())
		.append("Ingredient", dish.getIngredientTagList())
		.append("Taste", dish.getTasteTagList())
		.append("Cooking", dish.getCookingTagList());
		if(coll.insert(doc) != null)
			return true;
		return false;
	}

	@Override
	public boolean addIngredientTag(String tagName) {
		// TODO Auto-generated method stub
		DBCollection coll = mongodb.getCollection("Ingredient_Tag");		
		BasicDBObject doc = new BasicDBObject("tagName", tagName);		
		if(coll.insert(doc) != null)
			return true;	
		return false;
	}

	@Override
	public boolean addTasteTag(String tagName) {
		// TODO Auto-generated method stub
		DBCollection coll = mongodb.getCollection("Taste_Tag");		
		BasicDBObject doc = new BasicDBObject("tagName", tagName);		
		if(coll.insert(doc) != null)
			return true;	
		return false;
	}

	@Override
	public boolean addCookingTag(String tagName) {
		// TODO Auto-generated method stub
		DBCollection coll = mongodb.getCollection("Cooking_Tag");		
		BasicDBObject doc = new BasicDBObject("tagName", tagName);		
		if(coll.insert(doc) != null)
			return true;	
		return false;
	}

	@Override
	public boolean addDishSimilarity(ObjectId dishID, Map<ObjectId, Double> map) {
		// TODO Auto-generated method stub
		DBCollection coll = mongodb.getCollection("Similarity_Table");		
		BasicDBObject doc = new BasicDBObject("_id", dishID)
		.append("similarity", map);	
		if(coll.insert(doc) != null)
			return true;	
		return false;
	}

}
