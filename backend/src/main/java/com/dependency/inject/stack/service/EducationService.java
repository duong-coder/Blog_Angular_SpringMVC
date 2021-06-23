package com.dependency.inject.stack.service;

import java.util.List;

import com.dependency.inject.stack.service.dto.EducationDTO;

public interface EducationService {
	EducationDTO insert(EducationDTO dto);
	
	EducationDTO update(EducationDTO dto);

	boolean isExistById(int id);
	
	void delete(int id);
	
	EducationDTO findById(int id);
	
	List<EducationDTO> findAll();
	
	List<EducationDTO> findAllByAccountId(String id);

}
