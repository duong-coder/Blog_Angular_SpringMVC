package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.domain.WorkExperience;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.dto.WorkExperienceDTO;

@Component
public class WorkExperienceMapper implements EntityMapper<WorkExperience, WorkExperienceDTO, Integer>{

	@Autowired
	private EntityMapper<Account, AccountDTO, String> accountMapper;
	
	@Override
	public WorkExperience toEntity(WorkExperienceDTO dto) {
		WorkExperience wE = new WorkExperience();
		wE.setId(dto.getId());
		wE.setCompanyOrAppName(dto.getCompanyOrAppName());
		wE.setTitleOrPosition(dto.getTitleOrPosition());
		wE.setDescription(dto.getDescription());
		wE.setDateStart(dto.getDateStart());
		wE.setDateEnd(dto.getDateEnd());
		
		AccountDTO accountDTO = dto.getAccountDTO();
		if(accountDTO != null) {
			Account account = accountMapper.toEntityFromId(accountDTO.getUsername());
			wE.setAccount(account);
		}
		
		return wE;
	}

	@Override
	public WorkExperienceDTO toDTO(WorkExperience entity) {
		WorkExperienceDTO dto = new WorkExperienceDTO();
		dto.setId(entity.getId());
		dto.setCompanyOrAppName(entity.getCompanyOrAppName());
		dto.setTitleOrPosition(entity.getTitleOrPosition());
		dto.setDescription(entity.getDescription());
		dto.setDateStart(entity.getDateStart());
		dto.setDateEnd(entity.getDateEnd());
		
		Account account = entity.getAccount();
		if(account != null) {
			AccountDTO accountDTO = accountMapper.toDTOFromId(account.getUsername());
			dto.setAccountDTO(accountDTO);
		}
		
		return dto;
	}

	@Override
	public List<WorkExperienceDTO> toDTOs(List<WorkExperience> entities) {
		List<WorkExperienceDTO> dtos = new ArrayList<WorkExperienceDTO>();
		entities.forEach((entity) ->{
			WorkExperienceDTO dto = toDTO(entity);
			
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
	public WorkExperience toEntityFromId(Integer id) {
		WorkExperience wE = new WorkExperience();
		wE.setId(id);
		
		return wE;
	}
	
	@Override
	public WorkExperienceDTO toDTOFromId(Integer id) {
		WorkExperienceDTO dto = new WorkExperienceDTO(); 
		dto.setId(id);
		
		return dto;
	}
}
