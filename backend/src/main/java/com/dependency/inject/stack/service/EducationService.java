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

	List<EducationDTO> findAllDTOWillDelete(List<EducationDTO> dtos, String accountId);

	List<EducationDTO> findAllDTOWillAdd(List<EducationDTO> dtos, String accountId);

	void setSortIndex(int id);

}
