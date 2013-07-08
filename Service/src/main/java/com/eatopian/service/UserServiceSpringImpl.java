package com.eatopian.service;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.eatopian.dao.UserDao;
import com.eatopian.entity.User;

@Controller
@RequestMapping("/users")
public class UserServiceSpringImpl implements UserService {
	
	
	private UserDao userDao;
	
	@RequestMapping(method=RequestMethod.POST, headers = "Content-Type=application/xml")
	public @ResponseBody User register(@RequestBody User user) {
        
		//userDao.register(user);
		
		return user;
	}
	

	@RequestMapping(value="login", method=RequestMethod.POST)
	public User login(@RequestBody User user) {

		//userDao.login(user);
		
		return null;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
