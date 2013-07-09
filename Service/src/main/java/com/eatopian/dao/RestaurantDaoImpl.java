package com.eatopian.dao;

import java.net.UnknownHostException;
import java.util.List;

import com.eatopian.entity.Restaurant;
import com.eatopian.entity.Token;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;


public class RestaurantDaoImpl implements RestaurantDao {
	

	public RestaurantDaoImpl(){
		
	}
	
	
	public void createRestaurant(Restaurant restaurant, Token token) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Restaurant getRestaurant(String restaurantId, Token token) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addImage(String restaurantId, byte[] bytes, Token token) {
		try {


			MongoClient mongo = new MongoClient("g.sj.gs");
			DB db = mongo.getDB("GFS");
//			DBCollection collection = db.getCollection("images");
 
			String newFileName = "testimage";
			
//			File imageFile = new File("src/main/resources/dish1.png");

			// create image namespace
			GridFS GFS = new GridFS(db, "image");
 
			// get image file from local drive
			GridFSInputFile gfsFile = GFS.createFile(bytes);
			
			// set a new filename for identify purpose
			gfsFile.setFilename(newFileName);
			
			// save the image file into mongoDB
			gfsFile.save();
			
			// print the result
			DBCursor cursor = GFS.getFileList();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
 
//			// get image file by it's filename
//			GridFSDBFile imageForOutput = GFS.findOne(newFileName);
// 
//			// save it into a new image file
//			imageForOutput.writeTo("src/main/resources/dish2.png");
 
			// remove the image file from mongoDB
//			GFS.remove(GFS.findOne(newFileName));
//			System.out.println("Done");
 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}


	@Override
	public List<Restaurant> getRestaurants(Token token) {
		// TODO Auto-generated method stub
		return null;
	}




}
