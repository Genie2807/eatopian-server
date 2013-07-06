package com.eatopian.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eatopian.dao.RestaurantDao;
import com.eatopian.entity.Restaurant;
import com.eatopian.entity.User;

@Controller
@RequestMapping("/users")
public class RestaurantUserService implements UserService {
	
	
	private RestaurantDao restaurantDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUsers() {
		return "all users";
	}
	
	@RequestMapping(method=RequestMethod.POST, headers = "Content-Type=application/xml")
	public @ResponseBody User register(@RequestBody User user) {
        
        
		return user;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public void uploadImage(@RequestParam(value="image", required=false) MultipartFile image) {
        
		try {
			this.restaurantDao.saveImage(new Restaurant(), image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	@Autowired
	public void setRestaurantDao(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}
	
}
