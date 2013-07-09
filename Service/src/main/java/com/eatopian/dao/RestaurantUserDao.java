package com.eatopian.dao;
import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

public class RestaurantUserDao{
	
public static void main(String[] args) {

	try {

		MongoClient mongo = new MongoClient("g.sj.gs", 27017);
		DB db = mongo.getDB("GFS");
		// DBCollection collection = db.getCollection("images");

		String newFileName = "dish1";

//		File imageFile = new File("src/main/resources/dish1.png");
		
		// create image namespace
		GridFS GFS = new GridFS(db, "image");

		// get image file from local drive
//		GridFSInputFile gfsFile = GFS.createFile(imageFile);
//		
//		// set a new filename for identify purpose
//		gfsFile.setFilename(newFileName);
//		
//		BasicDBObject meta = new BasicDBObject();
//		meta.put("author", "Han");
//
//        gfsFile.setMetaData(meta);
//        
//		// save the image file into mongoDB
//		gfsFile.save();
		

		// get image file by it's filename
		GridFSDBFile imageForOutput = GFS.findOne(newFileName);
	
		byte[] bytes = IOUtils.toByteArray(imageForOutput.getInputStream());
		
		System.out.println(bytes.length);
		
		
		
		// save it into a new image file
//		ios.writeTo("src/main/resources/dish6.png");
		// remove the image file from mongoDB
		// GFS.remove(GFS.findOne(newFileName));
		// System.out.println("Done");

	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (MongoException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

}
	
}
