package com.dependency.inject.stack.service;

import java.util.List;

import com.dependency.inject.stack.service.dto.SkillDTO;

public interface SkillService {
	SkillDTO insert(SkillDTO dto);
	
	SkillDTO update(SkillDTO dto);

	boolean isExistById(int id);
	
	void delete(int id);
	
	SkillDTO findById(int id);
	
	List<SkillDTO> findAll();
	
	List<SkillDTO> findAllByAccountId(String id);

}
