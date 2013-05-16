package com.eatopian.service;

import com.eatopian.entity.User;

public interface UserService {
	void register(User user);
	void login(User user);
	User getUser(int id);
}
