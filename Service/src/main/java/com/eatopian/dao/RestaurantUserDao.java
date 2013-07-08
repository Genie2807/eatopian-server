//package com.eatopian.dao;
//import java.io.File;
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//import com.mongodb.DB;
//import com.mongodb.DBObject;
//import com.mongodb.Mongo;
//import com.mongodb.MongoException;
//import com.mongodb.gridfs.GridFS;
//import com.mongodb.gridfs.GridFSDBFile;
//import com.mongodb.gridfs.GridFSInputFile;
//
//public class RestaurantUserDao{
//	
//public static void main(String[] args) {
//
//	try {
//
//		Mongo mongo = new Mongo("g.sj.gs");
//		DB db = mongo.getDB("GFS");
//		// DBCollection collection = db.getCollection("images");
//
//		String newFileName = "dish1";
//
//		File imageFile = new File("src/main/resources/dish1.png");
//		
//		// create image namespace
//		GridFS GFS = new GridFS(db, "image");
//
//		// get image file from local drive
//		GridFSInputFile gfsFile = GFS.createFile(imageFile);
//
//		DBObject metadata = null;
//
//		gfsFile.setMetaData(metadata);
//
//		// set a new filename for identify purpose
//		gfsFile.setFilename(newFileName);
//
//		// save the image file into mongoDB
//		gfsFile.save();
//
//		// print the result
//		// DBCursor cursor = GFS.getFileList();
//		// while (cursor.hasNext()) {
//		// System.out.println(cursor.next());
//		// }
//
//
//		// get image file by it's filename
//		GridFSDBFile imageForOutput = GFS.findOne(newFileName);
//		// save it into a new image file
//		imageForOutput.writeTo("src/main/resources/dish2.png");
//
//		// remove the image file from mongoDB
//		// GFS.remove(GFS.findOne(newFileName));
//		// System.out.println("Done");
//
//	} catch (UnknownHostException e) {
//		e.printStackTrace();
//	} catch (MongoException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//
//}
//	
//}
