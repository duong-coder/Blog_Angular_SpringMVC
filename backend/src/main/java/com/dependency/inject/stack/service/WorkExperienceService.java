package com.dependency.inject.stack.service;

import java.util.List;

import com.dependency.inject.stack.service.dto.WorkExperienceDTO;

public interface WorkExperienceService {
	WorkExperienceDTO insert(WorkExperienceDTO dto);
	
	WorkExperienceDTO update(WorkExperienceDTO dto);

	boolean isExistById(int id);
	
	void delete(int id);
	
	WorkExperienceDTO findById(int id);
	
	List<WorkExperienceDTO> findAll();
	
	List<WorkExperienceDTO> findAllByAccountId(String id);

	List<WorkExperienceDTO> findAllDTOWillDelete(List<WorkExperienceDTO> experienceDTOs, String accountId);

	List<WorkExperienceDTO> findAllDTOWillAdd(List<WorkExperienceDTO> experienceDTOs, String accountId);

	void setOrderIndex(int id);

	long countByAccountId(String id);

}
