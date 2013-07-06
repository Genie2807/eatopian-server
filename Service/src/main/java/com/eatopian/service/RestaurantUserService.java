package com.eatopian.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eatopian.entity.User;

@Controller
@RequestMapping("/users")
public class RestaurantUserService implements UserService {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUsers() {
		return "all users";
	}
	
	@RequestMapping(method=RequestMethod.POST, headers = "Content-Type=application/xml")
	public @ResponseBody User register(@RequestBody User user) {
        
        
		return user;
	}
	
}
