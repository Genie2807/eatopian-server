package com.eatopian.dao;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.eatopian.entity.Account;
import com.eatopian.entity.Token;

@Repository
public class AccountDaoImpl implements AccountDao {

	private ApplicationContext ctx;

	@Autowired
	private MongoOperations mongoOperation;

	private SecureRandom random;

	public AccountDaoImpl() {
		this.ctx = new GenericXmlApplicationContext("mongodb-spring.xml");
		this.mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		this.random = new SecureRandom();
	}

	@Override
	public boolean login(Account account) {
		// TODO Auto-generated method stub
		Account realAccount = mongoOperation.findOne(new Query(Criteria.where("username").is(account.getUsername())), Account.class);
		if(realAccount == null){
			System.out.println("username does't exist");
			return false;
		}
		
		if(!realAccount.getPassword().equals(account.getPassword())){
			System.out.println("password doesn't match");
			return false;
		}

		account.setId(realAccount.getId());
		account.setToken(new Token(this.tokenGenerator()));
		mongoOperation.save(account);
		return true;
	}

	@Override
	public boolean register(Account account) {
		// TODO Auto-generated method stub
		
		long exist = this.mongoOperation.count(new Query(Criteria.where("username").is(account.getUsername())), Account.class);
		
		// user name already exists
		if(exist != 0){
			System.out.println("username already exists");
			return false;
		}
		
		// generate new token for this account
		account.setToken(new Token(this.tokenGenerator()));
		
		this.mongoOperation.save(account);
		
		return true;
	}

	private String tokenGenerator() {
		return new BigInteger(130, random).toString(32);
	}

//	@Test
//	public void test() {
//		 AccountDaoImpl adao = new AccountDaoImpl();
//		 Account ac = new Account("Han", "12345", "manager");
//		 System.out.println(adao.register(ac));
//		 System.out.println(adao.login(ac));		 
//	}

}
