package com.eatopian.service;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.eatopian.entity.User;

@Path("users")
public class RestaurantUserService implements UserService {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getUsers() {
		return "all users";
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
	public User register(User user) {
        
        
		return user;
	}
	
}
