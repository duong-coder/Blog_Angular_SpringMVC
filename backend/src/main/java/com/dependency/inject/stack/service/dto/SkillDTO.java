package com.dependency.inject.stack.service.dto;

import lombok.Data;

@Data
public class SkillDTO {
	private int id;
	private String skill;
	private int level;
	private AccountDTO accountDTO;
}
