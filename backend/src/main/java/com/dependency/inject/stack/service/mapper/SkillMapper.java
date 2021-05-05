package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.domain.Skill;
import com.dependency.inject.stack.service.dto.SkillDTO;

@Component
public class SkillMapper implements EntityMapper<Skill, SkillDTO>{

	@Override
	public Skill toEntity(SkillDTO dto) {
		Skill skill = new Skill();
		
		skill.setId(dto.getId());
		skill.setLevel(dto.getLevel());
		skill.setSkill(dto.getSkill());
		
		return skill;
	}

	@Override
	public SkillDTO toDto(Skill entity) {
		SkillDTO skillDTO = new SkillDTO();
		
		skillDTO.setId(entity.getId());
		skillDTO.setSkill(entity.getSkill());
		skillDTO.setLevel(entity.getLevel());
		
		return skillDTO;
	}

	@Override
	public List<SkillDTO> toDTOs(List<Skill> entities) {
		List<SkillDTO> skillDTOs = new ArrayList<SkillDTO>();
		entities.forEach((entity) ->{
			SkillDTO skillDTO = toDto(entity);
			
			skillDTOs.add(skillDTO);
		});
		
		return skillDTOs;
	}

	@Override
	public List<Skill> toEntities(List<SkillDTO> dtos) {
		List<Skill> skills = new ArrayList<Skill>();
		dtos.forEach((dto) ->{
			Skill skill = toEntity(dto);
			
			skills.add(skill);
		});
		
		return skills;
	}

	@Override
	public Skill toEntityFromId(Long id) {
		Skill skill = new Skill();
		skill.setId(id.intValue());
		
		return skill;
	}
	
}
