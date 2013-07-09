package com.eatopian.dao;

import com.eatopian.entity.Account;


public interface AccountDao {
	
	public boolean login(Account account);
	public boolean register(Account account);
	

}
