package com.dependency.inject.stack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Skill;
import com.dependency.inject.stack.repository.SkillRepository;
import com.dependency.inject.stack.service.SkillService;
import com.dependency.inject.stack.service.dto.SkillDTO;
import com.dependency.inject.stack.service.mapper.EntityMapper;

@Service
@Transactional
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private EntityMapper<Skill, SkillDTO, Integer> skillMapper;
	
	
	@Override
	public SkillDTO insert(SkillDTO dto) {
		if(dto == null) {
			return null;
		}
		Skill skill = skillMapper.toEntity(dto);
		Skill skillRT = skillRepository.save(skill);
		
		
		return skillMapper.toDTO(skillRT);
	}

	@Override
	public SkillDTO update(SkillDTO dto) {
		if(dto == null) {
			return null;
		}
		if(isExistById(dto.getId())) {
			Skill skill = skillMapper.toEntity(dto);
			Skill skillRT = skillRepository.save(skill);
			
			
			return skillMapper.toDTO(skillRT);
		}
		
		return null;
	}

	@Override
	public boolean isExistById(int id) {
		
		return skillRepository.existsById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SkillDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillDTO> findAllByAccountId(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
