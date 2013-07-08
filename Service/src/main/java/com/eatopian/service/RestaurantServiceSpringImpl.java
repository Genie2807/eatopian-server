package com.eatopian.service;

//import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//import com.eatopian.entity.Restaurant;

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
}
