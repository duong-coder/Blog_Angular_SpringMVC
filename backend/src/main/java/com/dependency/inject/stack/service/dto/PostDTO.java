package com.dependency.inject.stack.service.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
public class PostDTO {
	private int id;

	private String heading;
	
	private String subHeading;
	
	private String urlImage;
	
	private String content;
	
	private Date dateCreate;
	
}
