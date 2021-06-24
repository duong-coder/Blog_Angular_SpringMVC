package com.dependency.inject.stack.service.dto;

import java.util.Date;

import lombok.Data;

@Data
public class WorkExperienceDTO {
	private int id;
	private String companyOrAppName;
	private String titleOrPosition;
	private String description;
	private Date dateStart;
	private Date dateEnd;
	private int sortIndex;
	private AccountDTO accountDTO; 
	
}
