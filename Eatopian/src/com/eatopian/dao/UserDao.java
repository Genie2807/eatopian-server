package com.eatopian.dao;

import com.eatopian.entity.User;

public interface UserDao {
	public boolean register(User user);
	public boolean login(User user);
}
