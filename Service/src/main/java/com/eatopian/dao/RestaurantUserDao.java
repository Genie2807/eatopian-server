package com.eatopian.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eatopian.entity.Restaurant;
import com.eatopian.entity.User;


public class RestaurantUserDao implements UserDao {
	
	private DataSource dataSource;
	 

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
				user.setId((long)rs.getLong("id"));
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
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
