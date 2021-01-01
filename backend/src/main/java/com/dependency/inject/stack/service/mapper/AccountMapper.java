package com.dependency.inject.stack.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.domain.Post;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.dto.PostDTO;

@Component
public class AccountMapper implements EntityMapper<Account, AccountDTO>{
	
	@Autowired
	private PostMapper postMapper;
	
	@Override
	public Account toEntity(AccountDTO dto) {
		Account acc = new Account();
		acc.setPhonenumber(dto.getPhonenumber());
		acc.setPassword(dto.getPassword());
		acc.setFullname(dto.getFullname());
		acc.setGender(dto.isGender());
		acc.setAddress(dto.getAddress());
		acc.setAcademicLevel(dto.getAcademicLevel());
		acc.setBirthday(dto.getBirthday());
		acc.setEmail(dto.getEmail());
		acc.setFacebook(dto.getFacebook());
		acc.setGithub(dto.getGithub());
		acc.setTwitter(dto.getTwitter());
		acc.setWork(dto.getWork());
		acc.setDateCreate(dto.getDateCreate());
		
		List<Post> posts = new ArrayList<Post>();
		posts = postMapper.toEntities(dto.getPostDTOs());
		acc.setPosts(posts);

		return acc;
	}

	@Override
	public AccountDTO toDto(Account entity) {
		AccountDTO dto = new AccountDTO();
		dto.setPhonenumber(entity.getPhonenumber());
		dto.setPassword(entity.getPassword());
		dto.setFullname(entity.getFullname());
		dto.setGender(entity.isGender());
		dto.setAcademicLevel(entity.getAcademicLevel());
		dto.setAddress(entity.getAddress());
		dto.setBirthday(entity.getBirthday());
		dto.setDateCreate(entity.getDateCreate());
		dto.setEmail(entity.getEmail());
		dto.setGithub(entity.getGithub());
		dto.setTwitter(entity.getTwitter());
		dto.setWork(entity.getWork());
		dto.setFacebook(entity.getFacebook());
		
		List<PostDTO> postDTOs = new ArrayList<PostDTO>();
		postDTOs = postMapper.toDTOs(entity.getPosts());
		dto.setPostDTOs(postDTOs);
		
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

}
