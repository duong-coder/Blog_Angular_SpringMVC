package com.dependency.inject.stack.service.impl;

import java.util.ArrayList;
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
	public void setSortIndex(int id) {
		if (isExistById(id)) {
			educationRepository.setSortIndex(id);
		}
	}

	@Override
	public boolean isExistById(int id) {

		return educationRepository.existsById(id);
	}

	@Override
	public void delete(int id) {
		if(isExistById(id)) {
			educationRepository.deleteById(id);
		}
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
		List<Education> educations = educationRepository.findAllByAccountId(id);
		List<EducationDTO> dtos = new ArrayList<>();
		if(educations != null && !educations.isEmpty()) {
			dtos = educationMapper.toDTOs(educations);
		}
		
		return dtos;
	}
	
	@Override
	public List<EducationDTO> findAllDTOWillAdd(List<EducationDTO> dtos, String accountId){
		List<EducationDTO> educationsWillAdd = new ArrayList<>();
		if(dtos == null) {
			return educationsWillAdd;
		}
		List<EducationDTO> eduDTOsDB = findAllByAccountId(accountId);
		for(EducationDTO edu : dtos) {
			boolean isAdd = true;
			for(EducationDTO eduDB : eduDTOsDB) {
				if(eduDB.getId() == edu.getId()) {
					isAdd = false;
					break;
				}
			}
			if(isAdd) {
				educationsWillAdd.add(edu);
			}
		}
		
		return educationsWillAdd;
	}
	
	@Override
	public List<EducationDTO> findAllDTOWillDelete(List<EducationDTO> dtos, String accountId){
		List<EducationDTO> educationsWillDelete = new ArrayList<>();
		if(dtos == null) {
			return educationsWillDelete;
		}
		List<EducationDTO> educationDTOsDB = this.findAllByAccountId(accountId);
		for(EducationDTO eduDB : educationDTOsDB) {
			boolean isDelete = true;
			for(EducationDTO edu : dtos) {
				if(eduDB.getId() == edu.getId()) {
					isDelete = false;
					break;
				}
			}
			if(isDelete) {
				educationsWillDelete.add(eduDB);
			}
		}
		
		return educationsWillDelete;
	}
}
