package com.eatopian.dao;
//import java.io.File;
//import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.eatopian.entity.Restaurant;
import com.eatopian.entity.Account;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
//import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;



public class RestaurantDaoImpl implements RestaurantDao {
	
	private DataSource dataSource;

	public RestaurantDaoImpl(){
		
	}
	
	
	public void createRestaurant(Restaurant restaurant, String token) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Restaurant getRestaurant(String restaurantId, String token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void addImage(String restaurantId, byte[] bytes, String token) {
		try {

			@SuppressWarnings("deprecation")
			Mongo mongo = new Mongo("g.sj.gs");
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
	public List<Restaurant> getRestaurants(String token) {
		// TODO Auto-generated method stub
		return null;
	}




}
