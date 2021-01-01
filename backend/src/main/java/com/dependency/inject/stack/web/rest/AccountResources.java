package com.dependency.inject.stack.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency.inject.stack.service.AccountService;
import com.dependency.inject.stack.service.dto.AccountDTO;

@RestController
@RequestMapping(path = "/api/account")
public class AccountResources {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/{phone}")
	public AccountDTO getAccExist(@PathVariable("phone") String phone) {
		System.out.println("Phone:" + phone);
		AccountDTO accountDTO = accountService.findByPhone(phone);
		
		return accountDTO;
	}
	
}
