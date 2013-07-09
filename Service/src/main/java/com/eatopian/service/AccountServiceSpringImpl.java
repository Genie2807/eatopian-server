package com.eatopian.service;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.eatopian.dao.AccountDao;
import com.eatopian.entity.Account;

@Controller
@RequestMapping("/accounts")
public class AccountServiceSpringImpl implements AccountService {
	
	
	private AccountDao userDao;
	
	@RequestMapping(method=RequestMethod.POST, headers = "Content-Type=application/xml")
	public @ResponseBody Account register(@RequestBody Account account) {
        
		//userDao.register(user);
		
		return account;
	}
	

	@RequestMapping(value="login", method=RequestMethod.POST)
	public Account login(@RequestBody Account account) {

		//userDao.login(user);
		
		return null;
	}



	public void setUserDao(AccountDao userDao) {
		this.userDao = userDao;
	}
	
}
