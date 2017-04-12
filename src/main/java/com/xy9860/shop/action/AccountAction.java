package com.xy9860.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Account;

@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {

	public String query(){
		jsonList=accountService.query();
		return "jsonList";
	}
	
}
