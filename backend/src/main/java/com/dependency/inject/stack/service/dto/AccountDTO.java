package com.dependency.inject.stack.service.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AccountDTO {
	private String phonenumber;
	
	private String password;
	
	private Date dateCreate;
	
	private String fullname;
	
	private Date birthday;
	
	private String address;
	
	private String academicLevel;
	
	private String work;
	
	private String email;
	
	private boolean gender;
	
	private String github;
	
	private String facebook;
	
	private String twitter;
	
	private String role;
	
	private List<PostDTO> postDTOs;
}
