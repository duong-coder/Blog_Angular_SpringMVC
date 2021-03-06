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
@Table(name = "work_experience")
public class WorkExperience implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "company_or_app_name")
	private String companyOrAppName;

	@Column(name = "title_or_position")
	private String titleOrPosition;

	@Column(name = "description")
	private String description;
	
	@Column(name = "date_start")
	@Temporal(TemporalType.DATE)
	private Date dateStart;
	
	@Column(name = "date_end")
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	
	@Column(name = "sort_index")
	private int sortIndex;

	@ManyToOne
	@JoinColumn(name = "username")
	private Account account;
	
}
