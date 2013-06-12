package com.eatopian.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.eatopian.entity.User;
public class Mysql_Implementation implements UserDao {
	Connection con = null;
	public Mysql_Implementation(){		
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";       
        try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub	
		try {
			Statement st = con.createStatement();
			String sql = "insert into user(userName, password) VALUES('" + user.getUsername()+"', '" + user.getPassword() + "')";
			int res = st.executeUpdate(sql);
			if(res == 1){
				return true;
			}
        } catch (SQLException ex) {
        	System.err.println("Registration Failed...");
        }
		return false;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		try {
			Statement st = con.createStatement();
			String sql = "select id from user where userName = '" + user.getUsername() + "' and password = '" + user.getPassword() + "';";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				user.setId(rs.getInt("id"));
			}		
        } catch (SQLException ex) {
        	System.err.println("Login Failed...");
        	return false;
        }
		return true;
	}

	public static void main(String[] s){
		Mysql_Implementation MI = new Mysql_Implementation();
		User user = new User("Han", "12345");
		boolean res = MI.register(user);
		System.out.println("Registration:" + res);
		MI.login(user);
		System.out.println(user.getId() + "; " + user.getUsername() + "; " + user.getPassword());
	}
	
	
}
