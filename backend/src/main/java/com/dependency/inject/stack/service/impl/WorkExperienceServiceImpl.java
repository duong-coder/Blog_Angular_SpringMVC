package com.dependency.inject.stack.service.impl;

import java.util.ArrayList;
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
	public void setOrderIndex(int id) {
		if(isExistById(id)) {
			experienceRepository.setSortIndex(id);
		}
	}

	@Override
	public boolean isExistById(int id) {

		return experienceRepository.existsById(id);
	}

	@Override
	public void delete(int id) {
		experienceRepository.deleteById(id);
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
		List<WorkExperience> experiences = experienceRepository.findAllByAccountId(id);
		List<WorkExperienceDTO> dtos = new ArrayList<>();
		if(experiences != null && !experiences.isEmpty()) {
			dtos = weMapper.toDTOs(experiences);
		}
		
		return dtos;
	}
	
	@Override
	public long countByAccountId(String id) {
		return experienceRepository.countByAccountId(id);
	}
	
	@Override
	public List<WorkExperienceDTO> findAllDTOWillAdd(List<WorkExperienceDTO> experienceDTOs, String accountId){
		List<WorkExperienceDTO> experienceDTOsWillAdd = new ArrayList<>();
		if(experienceDTOs == null) {
			return experienceDTOsWillAdd;
		}
		List<WorkExperienceDTO> experienceDTOsInDB = this.findAllByAccountId(accountId);
		for(WorkExperienceDTO we : experienceDTOs) {
			boolean isAdd = true;
			for(WorkExperienceDTO weDB : experienceDTOsInDB) {
				if(weDB.getId() == we.getId()) {
					isAdd = false;
					break;
				}
			}
			if(isAdd) {
				experienceDTOsWillAdd.add(we);
			}
		}
		
		return experienceDTOsWillAdd;
	}
	
	@Override
	public List<WorkExperienceDTO> findAllDTOWillDelete(List<WorkExperienceDTO> experienceDTOs, String accountId){
		List<WorkExperienceDTO> experienceDTOsWillDelete = new ArrayList<>();
		if(experienceDTOs == null) {
			return experienceDTOsWillDelete;
		}
		
		List<WorkExperienceDTO> experienceDTOsInDB = this.findAllByAccountId(accountId);
		for(WorkExperienceDTO weDb : experienceDTOsInDB) {
			boolean isDelete = true;
			for(WorkExperienceDTO we : experienceDTOs) {
				if(we.getId() == weDb.getId()) {
					isDelete = false;
					break;
				}
			}
			if(isDelete) {
				experienceDTOsWillDelete.add(weDb);
			}
		}
		
		return experienceDTOsWillDelete;
	}
}
