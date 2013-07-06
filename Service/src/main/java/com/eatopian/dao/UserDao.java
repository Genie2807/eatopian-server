package com.eatopian.dao;

import com.eatopian.entity.User;


public interface UserDao {
	
	public boolean login(User user);
	public boolean register(User user);
	
	
}
