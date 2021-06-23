package com.dependency.inject.stack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.WorkExperience;
import com.dependency.inject.stack.repository.WorkExperienceRepository;
import com.dependency.inject.stack.service.WorkExperienceService;
import com.dependency.inject.stack.service.dto.WorkExperienceDTO;
import com.dependency.inject.stack.service.mapper.EntityMapper;

@Service
@Transactional
public class WorkExperienceServiceImpl implements WorkExperienceService{
	
	@Autowired
	private WorkExperienceRepository experienceRepository;
	@Autowired
	private EntityMapper<WorkExperience, WorkExperienceDTO, Integer> weMapper;
	
	@Override
	public WorkExperienceDTO insert(WorkExperienceDTO dto) {
		if(dto == null) {
			return null;
		}
		WorkExperience we = weMapper.toEntity(dto);
		WorkExperience weRT = experienceRepository.save(we); 
		
		return weMapper.toDTO(weRT);
	}

	@Override
	public WorkExperienceDTO update(WorkExperienceDTO dto) {
		if(dto == null) {
			return null;
		}
		if(isExistById(dto.getId())) {
			WorkExperience we = weMapper.toEntity(dto);
			WorkExperience weRT = experienceRepository.save(we); 
			
			return weMapper.toDTO(weRT);
		}
		
		return null;
	}

	@Override
	public boolean isExistById(int id) {

		return experienceRepository.existsById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WorkExperienceDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkExperienceDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkExperienceDTO> findAllByAccountId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
