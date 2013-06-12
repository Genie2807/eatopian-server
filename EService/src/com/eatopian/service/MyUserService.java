package com.eatopian.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class MyUserService implements UserService {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "hello";
	}
}
