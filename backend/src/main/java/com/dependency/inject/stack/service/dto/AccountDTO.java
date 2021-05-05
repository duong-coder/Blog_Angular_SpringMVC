package com.dependency.inject.stack.service.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import lombok.Data;

@Data
public class AccountDTO {
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
	
}
