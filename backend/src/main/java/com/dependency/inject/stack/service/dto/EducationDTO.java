package com.dependency.inject.stack.service.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EducationDTO {
	private int id;
	private String name;
	private String description;
	private float gpa;
	private Date dateStart;
	private Date dateEnd;
	private AccountDTO accountDTO;
}
