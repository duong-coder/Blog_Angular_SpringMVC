package com.dependency.inject.stack.service.impl;

import java.util.ArrayList;
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
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private EntityMapper<Skill, SkillDTO, Integer> skillMapper;

	@Override
	public SkillDTO insert(SkillDTO dto) {
		if (dto == null) {
			return null;
		}
		Skill skill = skillMapper.toEntity(dto);
		Skill skillRT = skillRepository.save(skill);

		return skillMapper.toDTO(skillRT);
	}

	@Override
	public SkillDTO update(SkillDTO dto) {
		if (dto == null) {
			return null;
		}
		if (isExistById(dto.getId())) {
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
		if (isExistById(id)) {
			skillRepository.deleteById(id);
		}
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
		List<Skill> skills = skillRepository.findAllByAccountId(id);
		List<SkillDTO> skillDTOs = new ArrayList<>();
		if (skills != null && !skills.isEmpty()) {
			skillDTOs = skillMapper.toDTOs(skills);
		}

		return skillDTOs;
	}
	
	@Override
	public long countByAccountId(String id) {
		return skillRepository.countByAccountId(id);
	}
	
	@Override
	public List<SkillDTO> findAllDTOWillAdd(List<SkillDTO> dtos, String accountId) {
		List<SkillDTO> skillsWillAdd = new ArrayList<>();
		if (dtos == null) {
			return skillsWillAdd;
		}
		List<SkillDTO> skillDTOsDB = this.findAllByAccountId(accountId);
		for (SkillDTO skill : dtos) {
			boolean isAdd = true;
			for(SkillDTO skillDB : skillDTOsDB) {
				if(skillDB.getId() == skill.getId()) {
					isAdd = false;
					break;
				}
			}
			if (isAdd) {
				skillsWillAdd.add(skill);
			}
		}

		return skillsWillAdd;
	}

	@Override
	public List<SkillDTO> findAllDTOWillDelete(List<SkillDTO> dtos, String accountId) {
		List<SkillDTO> skillsWillDelete = new ArrayList<>();
		if (dtos == null) {
			return skillsWillDelete;
		}
		List<SkillDTO> SkillDTOsDB = this.findAllByAccountId(accountId);
		for (SkillDTO skillDB : SkillDTOsDB) {
			boolean isDelete = true;
			for (SkillDTO skill : dtos) {
				if (skillDB.getId() == skill.getId()) {
					isDelete = false;
					break;
				}
			}
			if (isDelete) {
				skillsWillDelete.add(skillDB);
			}
		}

		return skillsWillDelete;
	}
}
