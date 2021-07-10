package com.dependency.inject.stack.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.repository.AccountRepository;
import com.dependency.inject.stack.service.AccountService;
import com.dependency.inject.stack.service.EducationService;
import com.dependency.inject.stack.service.SkillService;
import com.dependency.inject.stack.service.WorkExperienceService;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.dto.EducationDTO;
import com.dependency.inject.stack.service.dto.SkillDTO;
import com.dependency.inject.stack.service.dto.WorkExperienceDTO;
import com.dependency.inject.stack.service.mapper.EntityMapper;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private EntityMapper<Account, AccountDTO, String> accountMapper;

	@Autowired
	private SkillService skillService;
	@Autowired
	private EducationService educationService;
	@Autowired
	private WorkExperienceService weService;

	@Override
	public AccountDTO update(AccountDTO dto) {
		if (dto == null) {
			return null;
		}
		if (isExistById(dto.getUsername())) {

			List<SkillDTO> skillDTOs = dto.getSkillDTOs();
			if (skillDTOs != null) {
				List<SkillDTO> skillDTOsWillDelete = skillService.findAllDTOWillDelete(skillDTOs, dto.getUsername());
				skillDTOsWillDelete.forEach(skill -> {
					long countSkill = skillService.countByAccountId(dto.getUsername());
					if (countSkill > 1) {
						skillService.delete(skill.getId());
					}
				});
				List<SkillDTO> skillDTOsWillAdd = skillService.findAllDTOWillAdd(skillDTOs, dto.getUsername());
				skillDTOsWillAdd.forEach(skill -> {
					skillService.insert(skill);
				});
				skillDTOs.forEach((s) -> {
					skillService.update(s);
				});
			}
			List<EducationDTO> educationDTOs = dto.getEducationDTOs();
			if (educationDTOs != null) {
				List<EducationDTO> eduDTOsWillDelete = educationService.findAllDTOWillDelete(educationDTOs,
						dto.getUsername());
				eduDTOsWillDelete.forEach(edu -> {
					long countEducation = educationService.countByAccountId(dto.getUsername());
					if (countEducation > 1) {
						educationService.delete(edu.getId());
					}
				});
				List<EducationDTO> eduDTOsWillAdd = educationService.findAllDTOWillAdd(educationDTOs,
						dto.getUsername());
				eduDTOsWillAdd.forEach(edu -> {
					educationService.insert(edu);
//					EducationDTO dtoRT = educationService.insert(edu);
//					educationService.setSortIndex(dtoRT.getId());
				});
				educationDTOs.forEach(e -> {
					educationService.update(e);
				});
			}
			List<WorkExperienceDTO> weDTOs = dto.getWorkExperienceDTOs();
			if (weDTOs != null) {
				List<WorkExperienceDTO> weDTOsWillDelete = weService.findAllDTOWillDelete(weDTOs, dto.getUsername());
				weDTOsWillDelete.forEach(we -> {
					long countWE = weService.countByAccountId(dto.getUsername());
					if (countWE > 1) {
						weService.delete(we.getId());
					}
				});
				List<WorkExperienceDTO> weDTOsWillAdd = weService.findAllDTOWillAdd(weDTOs, dto.getUsername());
				weDTOsWillAdd.forEach(we -> {
					weService.insert(we);
				});
				weDTOs.forEach(w -> {
					weService.update(w);
				});
			}

			Account account = accountMapper.toEntity(dto);
			Account accountRT = accountRepository.save(account);

			return accountMapper.toDTO(accountRT);
		}

		return null;
	}

	@Override
	public AccountDTO findById(String id) {
		Optional<Account> entityOp = accountRepository.findById(id);
		if (entityOp.isPresent()) {
			return accountMapper.toDTO(entityOp.get());
		}

		return null;
	}

	@Override
	public boolean isExistById(String id) {
		return accountRepository.existsById(id);
	}

	@Override
	public AccountDTO getLinkSocialNetworkById(String id) {
		Account account = accountRepository.getLinkSocialNetworkById(id);
		if (account != null) {
			return accountMapper.toDTO(account);
		}

		return null;
	}
}
