package com.dependency.inject.stack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Education;
import com.dependency.inject.stack.repository.EducationRepository;
import com.dependency.inject.stack.service.EducationService;
import com.dependency.inject.stack.service.dto.EducationDTO;
import com.dependency.inject.stack.service.mapper.EntityMapper;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;
	@Autowired
	private EntityMapper<Education, EducationDTO, Integer> educationMapper;

	@Override
	public EducationDTO insert(EducationDTO dto) {
		if (dto == null) {
			return null;
		}
		Education education = educationMapper.toEntity(dto);
		Education educationRT = educationRepository.save(education);

		return educationMapper.toDTO(educationRT);
	}

	@Override
	public EducationDTO update(EducationDTO dto) {
		if (dto == null) {
			return null;
		}
		if (isExistById(dto.getId())) {
			Education education = educationMapper.toEntity(dto);
			Education educationRT = educationRepository.save(education);

			return educationMapper.toDTO(educationRT);
		}
		return null;
	}

	@Override
	public boolean isExistById(int id) {

		return educationRepository.existsById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public EducationDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationDTO> findAllByAccountId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
