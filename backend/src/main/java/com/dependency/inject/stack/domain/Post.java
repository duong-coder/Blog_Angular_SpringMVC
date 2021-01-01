package com.dependency.inject.stack.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "heading")
	private String heading;
	
	@Column(name = "sub_heading")
	private String subHeading;
	
	@Column(name = "url_image")
	private String urlImage;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "date_create")
	private Date dateCreate;
	
	@ManyToOne
	@JoinColumn(name = "phone_number")
	private Account account;
}
