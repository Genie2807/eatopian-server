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
	
	
	private AccountDao accountDao;
	
	@RequestMapping(value="register", method=RequestMethod.POST, produces={"application/xml"})
	public @ResponseBody Account register(@RequestBody Account account) {
        
		//accountDao.register(user);
		
		return account;
	}
	

	@RequestMapping(value="login", method=RequestMethod.POST)
	public Account login(@RequestBody Account account) {

		//accountDao.login(user);
		
		return null;
	}



	public void setUserDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
}
