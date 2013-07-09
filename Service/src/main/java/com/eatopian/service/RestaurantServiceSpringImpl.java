package com.eatopian.service;

//import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eatopian.entity.Restaurant;

@Controller
@RequestMapping("/restaurants")
public class RestaurantServiceSpringImpl implements RestaurantService {
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public void uploadImage(@RequestParam(value="image", required=false) MultipartFile image) {
        
//		try {
//			this.restaurantDao.saveImage(new Restaurant(), image.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public void createRestaurant(Restaurant restaurant) {
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Restaurant getRestaurant(String id) {
		
		return null;
	}
}
