package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.WorkExperience;
import com.dependency.inject.stack.service.dto.WorkExperienceDTO;

import liquibase.pro.packaged.ex;

@Component
public class WorkExperienceMapper implements EntityMapper<WorkExperience, WorkExperienceDTO>{

	@Override
	public WorkExperience toEntity(WorkExperienceDTO dto) {
		WorkExperience wE = new WorkExperience();
		wE.setId(dto.getId());
		wE.setCompanyOrAppName(dto.getCompanyOrAppName());
		wE.setTitleOrPosition(dto.getTitleOrPosition());
		wE.setDescription(dto.getDescription());
		wE.setDateStart(dto.getDateStart());
		wE.setDateEnd(dto.getDateEnd());
		
		return wE;
	}

	@Override
	public WorkExperienceDTO toDto(WorkExperience entity) {
		WorkExperienceDTO dto = new WorkExperienceDTO();
		dto.setId(entity.getId());
		dto.setCompanyOrAppName(entity.getCompanyOrAppName());
		dto.setTitleOrPosition(entity.getTitleOrPosition());
		dto.setDescription(entity.getDescription());
		dto.setDateStart(entity.getDateStart());
		dto.setDateEnd(entity.getDateEnd());
		
		return dto;
	}

	@Override
	public List<WorkExperienceDTO> toDTOs(List<WorkExperience> entities) {
		List<WorkExperienceDTO> dtos = new ArrayList<WorkExperienceDTO>();
		entities.forEach((entity) ->{
			WorkExperienceDTO dto = toDto(entity);
			
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public List<WorkExperience> toEntities(List<WorkExperienceDTO> dtos) {
		List<WorkExperience> experiences = new ArrayList<WorkExperience>();
		dtos.forEach((dto) ->{
			WorkExperience experience = toEntity(dto);
			
			experiences.add(experience);
		});
		
		return experiences;
	}

	@Override
	public WorkExperience toEntityFromId(Long id) {
		WorkExperience wE = new WorkExperience();
		wE.setId(id.intValue());
		
		return wE;
	}
	
}
