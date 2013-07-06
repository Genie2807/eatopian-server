package com.eatopian.dao;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.eatopian.entity.User;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;



public class RestaurantUserDao implements UserDao {
	
	private DataSource dataSource;

	public RestaurantUserDao(){
		
	}

	public boolean login(User user) {
		String checkSql = "SELECT * FROM Restaurant WHERE username = ? and password = ?";
		Connection conn = null;
		 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(checkSql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt("id"));
			}else{
				rs.close();
				ps.close();
				return false;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
			
		return true;
	}
	
	public boolean register(User user) {
		String checkSql = "SELECT * FROM Restaurant WHERE username = ?";
		
		String insertSql = "INSERT INTO Restaurant " +
				"(username, password) VALUES (?, ?)";
		
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(checkSql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				return false;
			}
			
			ps = conn.prepareStatement(insertSql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			int result = ps.executeUpdate();
			System.out.println(result);
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
			
		return true;
	}
	
	
//	public static void main( String[] args )
//    {
//    	ApplicationContext context = 
//    		new ClassPathXmlApplicationContext("application-context.xml");
// 
//    	RestaurantUserDao rd = (RestaurantUserDao) context.getBean("RestaurantUserDao");
//		Restaurant user = new Restaurant();
//		user.setUsername("root1");
//		user.setPassword("123");
//		boolean x = rd.register(user);
//		System.out.println(x);
//		
//		
//		boolean y = rd.login(user);
//		System.out.println(y);
//		
//		user.setUsername("root2");
//		user.setPassword("123");
//		
//		boolean z = rd.login(user);
//		System.out.println(z);
//    }


/*
 * GFS test	
 */
	
	public static void main(String[] args) {
		 
		try {
 
			Mongo mongo = new Mongo("g.sj.gs");
			DB db = mongo.getDB("GFS");
//			DBCollection collection = db.getCollection("images");
 
			String newFileName = "dish1";
			
			File imageFile = new File("src/main/resources/dish1.png");

			// create image namespace
			GridFS GFS = new GridFS(db, "image");
 
			// get image file from local drive
			GridFSInputFile gfsFile = GFS.createFile(imageFile);
			
			// set a new filename for identify purpose
			gfsFile.setFilename(newFileName);
			
			// save the image file into mongoDB
			gfsFile.save();
			
			// print the result
			DBCursor cursor = GFS.getFileList();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
 
			// get image file by it's filename
			GridFSDBFile imageForOutput = GFS.findOne(newFileName);
 
			// save it into a new image file
			imageForOutput.writeTo("src/main/resources/dish2.png");
 
			// remove the image file from mongoDB
//			GFS.remove(GFS.findOne(newFileName));
//			System.out.println("Done");
 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
