package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.domain.Skill;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.dto.SkillDTO;

@Component
public class SkillMapper implements EntityMapper<Skill, SkillDTO, Integer> {

	@Autowired
	private EntityMapper<Account, AccountDTO, String> accountMapper;

	@Override
	public Skill toEntity(SkillDTO dto) {
		Skill skill = new Skill();

		skill.setId(dto.getId());
		skill.setLevel(dto.getLevel());
		skill.setSkill(dto.getSkill());
		skill.setSortIndex(dto.getSortIndex());

		AccountDTO accountDTO = dto.getAccountDTO();
		if (accountDTO != null) {
			Account account = accountMapper.toEntityFromId(accountDTO.getUsername());
			skill.setAccount(account);
		}

		return skill;
	}

	@Override
	public SkillDTO toDTO(Skill entity) {
		SkillDTO skillDTO = new SkillDTO();

		skillDTO.setId(entity.getId());
		skillDTO.setSkill(entity.getSkill());
		skillDTO.setLevel(entity.getLevel());
		skillDTO.setSortIndex(entity.getSortIndex());

		Account account = entity.getAccount();
		if (account != null) {
			AccountDTO dto = accountMapper.toDTOFromId(account.getUsername());
			skillDTO.setAccountDTO(dto);
		}

		return skillDTO;
	}

	@Override
	public List<SkillDTO> toDTOs(List<Skill> entities) {
		if (entities != null && !entities.isEmpty()) {
			List<SkillDTO> skillDTOs = new ArrayList<SkillDTO>();
			entities.forEach((entity) -> {
				SkillDTO skillDTO = toDTO(entity);

				skillDTOs.add(skillDTO);
			});

			return skillDTOs;
		}

		return new ArrayList<SkillDTO>();
	}

	@Override
	public List<Skill> toEntities(List<SkillDTO> dtos) {
		if (dtos != null && !dtos.isEmpty()) {
			List<Skill> skills = new ArrayList<Skill>();
			dtos.forEach((dto) -> {
				Skill skill = toEntity(dto);

				skills.add(skill);
			});

			return skills;
		}

		return new ArrayList<Skill>();
	}

	@Override
	public Skill toEntityFromId(Integer id) {
		Skill skill = new Skill();
		skill.setId(id);

		return skill;
	}

	@Override
	public SkillDTO toDTOFromId(Integer id) {
		SkillDTO dto = new SkillDTO();
		dto.setId(id);

		return dto;
	}
}
