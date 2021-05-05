package com.dependency.inject.stack.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "account")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "phone_number")
	private String phonenumber;
	
	@Column(name = "pass_word")
	private String password;
	
	@Column(name = "date_create")
	private Date dateCreate;
	
	@Column(name = "full_name")
	private String fullname;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private boolean gender;
	
	@Column(name = "github")
	private String github;
	
	@Column(name = "facebook")
	private String facebook;
	
	@Column(name = "twitter")
	private String twitter;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "hobby")
	private String hobby;
	
	@Column(name = "objective")
	private String objective;
	
	@Column(name = "add_information")
	private String addInformation;
	
	@Column(name = "references")
	private String references;
	
	@Column(name = "awards")
	private String awards;	
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<Post> posts;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<Education> educations;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<WorkExperience> workExperiences;
	
}
