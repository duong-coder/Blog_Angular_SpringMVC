package com.dependency.inject.stack.service.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	
	private String username;
	private String phonenumber;
	private String password;
	private Date dateCreate;
	private String fullname;
	private Date birthday;
	private String address;
	private String email;
	private boolean gender;
	private String github;
	private String facebook;
	private String twitter;
	private String role;
	private String hobby;
	private String objective;
	private String addInformation;
	private String references;
	private String awards;	
	
	private List<PostDTO> postDTOs;
	private List<SkillDTO> skillDTOs;
	private List<EducationDTO> educationDTOs;
	private List<WorkExperienceDTO> workExperienceDTOs;
	
	public AccountDTO (String username) {
		this.username = username;
	}
}
