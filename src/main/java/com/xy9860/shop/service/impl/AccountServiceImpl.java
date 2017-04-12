package com.xy9860.shop.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy9860.shop.dao.AccountDao;
import com.xy9860.shop.model.Account;
import com.xy9860.shop.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	public List<Account> query() {
		// TODO Auto-generated method stub
		return accountDao.query();
	}
	
	
}
