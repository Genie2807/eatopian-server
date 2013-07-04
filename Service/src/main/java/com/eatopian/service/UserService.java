package com.eatopian.service;

import com.eatopian.entity.User;



public interface UserService {
	
    public String getUsers();
    public String register(User user);
}
