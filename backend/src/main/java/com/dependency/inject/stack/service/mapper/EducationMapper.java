package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.Education;
import com.dependency.inject.stack.service.dto.EducationDTO;

@Component
public class EducationMapper implements EntityMapper<Education, EducationDTO>{

	@Override
	public Education toEntity(EducationDTO dto) {
		Education education = new Education();
		education.setId(dto.getId());
		education.setName(dto.getName());
		education.setDescription(dto.getDescription());
		education.setGpa(dto.getGpa());
		education.setDateStart(dto.getDateStart());
		education.setDateEnd(dto.getDateEnd());
		
		return education;
	}

	@Override
	public EducationDTO toDto(Education entity) {
		EducationDTO dto = new EducationDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setGpa(entity.getGpa());
		dto.setDateStart(entity.getDateStart());
		dto.setDateEnd(entity.getDateEnd());
		
		return dto;
	}

	@Override
	public List<EducationDTO> toDTOs(List<Education> entities) {
		List<EducationDTO> educationDTOs = new ArrayList<EducationDTO>();
		entities.forEach((entity) ->{
			EducationDTO dto = toDto(entity);
			
			educationDTOs.add(dto);
		});
		
		return educationDTOs;
	}

	@Override
	public List<Education> toEntities(List<EducationDTO> dtos) {
		List<Education> educations = new ArrayList<Education>();
		dtos.forEach((dto) ->{
			Education education = toEntity(dto);
			
			educations.add(education);
		});

		return educations;
	}

	@Override
	public Education toEntityFromId(Long id) {
		Education education = new Education();
		education.setId(id.intValue());
		
		return education;
	}
	
}
