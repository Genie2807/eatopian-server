package com.eatopian.service;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.eatopian.entity.User;

@Path("users")
public class MyUserService implements UserService {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "hellooooooooo";
	}
	
	@POST
    @Consumes("application/xml")
    @Produces(MediaType.TEXT_PLAIN)
	public String post(User user) {
        
        
		return user.getUsername() + " " + user.getPassword();
	}
	
}
