package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.domain.Education;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.dto.EducationDTO;

@Component
public class EducationMapper implements EntityMapper<Education, EducationDTO, Integer> {

	@Autowired
	private EntityMapper<Account, AccountDTO, String> accountMapper;

	@Override
	public Education toEntity(EducationDTO dto) {
		Education education = new Education();
		education.setId(dto.getId());
		education.setName(dto.getName());
		education.setDescription(dto.getDescription());
		education.setGpa(dto.getGpa());
		education.setDateStart(dto.getDateStart());
		education.setDateEnd(dto.getDateEnd());

		AccountDTO accountDTO = dto.getAccountDTO();
		if (accountDTO != null) {
			Account account = accountMapper.toEntityFromId(accountDTO.getUsername());
			education.setAccount(account);
		}

		return education;
	}

	@Override
	public EducationDTO toDTO(Education entity) {
		EducationDTO dto = new EducationDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setGpa(entity.getGpa());
		dto.setDateStart(entity.getDateStart());
		dto.setDateEnd(entity.getDateEnd());

		Account account = entity.getAccount();
		if (account != null) {
			AccountDTO accountDTO = accountMapper.toDTOFromId(account.getUsername());
			dto.setAccountDTO(accountDTO);
		}

		return dto;
	}

	@Override
	public List<EducationDTO> toDTOs(List<Education> entities) {
		if (entities != null && !entities.isEmpty()) {
			List<EducationDTO> educationDTOs = new ArrayList<EducationDTO>();
			entities.forEach((entity) -> {
				EducationDTO dto = toDTO(entity);

				educationDTOs.add(dto);
			});

			return educationDTOs;
		}

		return new ArrayList<EducationDTO>();
	}

	@Override
	public List<Education> toEntities(List<EducationDTO> dtos) {
		if (dtos != null && !dtos.isEmpty()) {
			List<Education> educations = new ArrayList<Education>();
			dtos.forEach((dto) -> {
				Education education = toEntity(dto);

				educations.add(education);
			});

			return educations;
		}
		return new ArrayList<Education>();
	}

	@Override
	public Education toEntityFromId(Integer id) {
		Education education = new Education();
		education.setId(id.intValue());

		return education;
	}

	@Override
	public EducationDTO toDTOFromId(Integer id) {
		EducationDTO dto = new EducationDTO();
		dto.setId(id);

		return dto;
	}
}
