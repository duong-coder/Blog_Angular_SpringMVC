package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.domain.Education;
import com.dependency.inject.stack.domain.Post;
import com.dependency.inject.stack.domain.Skill;
import com.dependency.inject.stack.domain.WorkExperience;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.dto.EducationDTO;
import com.dependency.inject.stack.service.dto.PostDTO;
import com.dependency.inject.stack.service.dto.SkillDTO;
import com.dependency.inject.stack.service.dto.WorkExperienceDTO;

@Component
public class AccountMapper implements EntityMapper<Account, AccountDTO>{
	
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private SkillMapper skillMapper;
	@Autowired
	private EducationMapper educationMapper;
	@Autowired
	private WorkExperienceMapper experienceMapper;
	
	@Override
	public Account toEntity(AccountDTO dto) {
		Account acc = new Account();
		acc.setPhonenumber(dto.getPhonenumber());
		acc.setPassword(dto.getPassword());
		acc.setFullname(dto.getFullname());
		acc.setGender(dto.isGender());
		acc.setAddress(dto.getAddress());
		acc.setBirthday(dto.getBirthday());
		acc.setEmail(dto.getEmail());
		acc.setFacebook(dto.getFacebook());
		acc.setGithub(dto.getGithub());
		acc.setTwitter(dto.getTwitter());
		acc.setRole(dto.getRole());
		acc.setDateCreate(dto.getDateCreate());
		acc.setHobby(dto.getHobby());
		acc.setAddInformation(dto.getAddInformation());
		acc.setAwards(dto.getAwards());
		acc.setObjective(dto.getObjective());
		acc.setReferences(dto.getReferences());
		
		List<Post> posts = new ArrayList<Post>();
		posts = postMapper.toEntities(dto.getPostDTOs());
		acc.setPosts(posts);
		
		List<Skill> skills = new ArrayList<Skill>();
		skills = skillMapper.toEntities(dto.getSkillDTOs());
		acc.setSkills(skills);
		
		List<Education> educations = new ArrayList<Education>();
		educations = educationMapper.toEntities(dto.getEducationDTOs());
		acc.setEducations(educations);
		
		List<WorkExperience> experiences = new ArrayList<WorkExperience>();
		experiences = experienceMapper.toEntities(dto.getWorkExperienceDTOs());
		acc.setWorkExperiences(experiences);

		return acc;
	}

	@Override
	public AccountDTO toDto(Account entity) {
		AccountDTO dto = new AccountDTO();
		dto.setPhonenumber(entity.getPhonenumber());
		dto.setPassword(entity.getPassword());
		dto.setFullname(entity.getFullname());
		dto.setGender(entity.isGender());
		dto.setAddress(entity.getAddress());
		dto.setBirthday(entity.getBirthday());
		dto.setDateCreate(entity.getDateCreate());
		dto.setEmail(entity.getEmail());
		dto.setGithub(entity.getGithub());
		dto.setTwitter(entity.getTwitter());
		dto.setFacebook(entity.getFacebook());
		dto.setRole(entity.getRole());
		dto.setHobby(entity.getHobby());
		dto.setAddInformation(entity.getAddInformation());
		dto.setAwards(entity.getAwards());
		dto.setReferences(entity.getReferences());
		dto.setObjective(entity.getObjective());
		
		List<PostDTO> postDTOs = new ArrayList<PostDTO>();
		postDTOs = postMapper.toDTOs(entity.getPosts());
		dto.setPostDTOs(postDTOs);
		
		List<SkillDTO> skillDTOs = new ArrayList<SkillDTO>();
		skillDTOs = skillMapper.toDTOs(entity.getSkills());
		dto.setSkillDTOs(skillDTOs);
		
		List<EducationDTO> educationDTOs = new ArrayList<EducationDTO>();
		educationDTOs = educationMapper.toDTOs(entity.getEducations());
		dto.setEducationDTOs(educationDTOs);

		List<WorkExperienceDTO> experienceDTOs = new ArrayList<WorkExperienceDTO>();
		experienceDTOs = experienceMapper.toDTOs(entity.getWorkExperiences());
		dto.setWorkExperienceDTOs(experienceDTOs);
		
		return dto;
	}

	@Override
	public List<AccountDTO> toDTOs(List<Account> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> toEntities(List<AccountDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account toEntityFromId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Account toEntityFromId(String id) {
		Account account = new Account();
		account.setPhonenumber(id);
		
		return account;
	}
}
