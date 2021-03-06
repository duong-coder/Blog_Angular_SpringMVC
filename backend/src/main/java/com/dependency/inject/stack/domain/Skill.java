package com.dependency.inject.stack.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "skills")
public class Skill implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "skill")
	private String skill;
	
	@Column(name = "level")
	private int level;

	@Column(name = "sort_index")
	private int sortIndex;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Account account;
}
