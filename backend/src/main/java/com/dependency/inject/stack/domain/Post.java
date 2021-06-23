package com.dependency.inject.stack.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.DATE)
	private Date dateCreate;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Account account;
}
