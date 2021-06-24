package com.dependency.inject.stack.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
//	@Autowired
//	private WorkExperienceService weService;
	
	@GetMapping(path = "/{username}")
	public ResponseEntity<Response> getAccount(@PathVariable("username") String username) {
		Response response = null;
		try {
			AccountDTO accountDTO = accountService.findById(username);
			if(accountDTO != null) {
				response = new Response("Get account success", 200, accountDTO);
			}else {
				response = new Response("Account not found", 200, accountDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response("System error", 500, null);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<Response> updateAccount(@RequestBody AccountDTO accountDTO){
		Response response = null;
		System.out.println("ACCOUNT UPDATE: " + accountDTO.toString());
		try {
			boolean isExist = accountService.isExistById(accountDTO.getUsername());
			if(isExist) {
				AccountDTO accountDTORT = accountService.update(accountDTO);
				if(accountDTORT != null) {
					response = new Response("update account success", 200, accountDTORT);
				}else {
					response = new Response("update fail", 200, accountDTORT);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response("System error", 500, null);
		}
		
		return ResponseEntity.ok(response);
	}
	
	
}
