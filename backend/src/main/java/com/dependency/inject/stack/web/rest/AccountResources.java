package com.dependency.inject.stack.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency.inject.stack.service.AccountService;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.web.response.Response;

@RestController
@RequestMapping(path = "/api/account")
public class AccountResources {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/{phone}")
	public ResponseEntity<Response> getAccExist(@PathVariable("phone") String phone) {
		System.out.println("Phone:" + phone);
		Response response = null;
		try {
			AccountDTO accountDTO = accountService.findByPhone(phone);
			if(accountDTO != null) {
				response = new Response("Get account success", 200, accountDTO);
			}else {
				response = new Response("No found account", 200, accountDTO);
			}
		} catch (Exception e) {
			response = new Response("System error", 500, null);
		}
		
		return ResponseEntity.ok(response);
	}
	
}
