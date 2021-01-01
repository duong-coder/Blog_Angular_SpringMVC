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
public class PostMapper implements EntityMapper<Post, PostDTO>{
	@Autowired
	private EntityMapper<Account, AccountDTO> accountMapper;
	
	@Override
	public Post toEntity(PostDTO dto) {
		Post post = new Post();
		
		Account account = new Account();
		account.setPhonenumber("0773314448");
		post.setAccount(account);
		
		post.setId(dto.getId());
		post.setHeading(dto.getHeading());
		post.setSubHeading(dto.getSubHeading());
		post.setUrlImage(dto.getUrlImage());
		post.setDateCreate(dto.getDateCreate());
		post.setContent(dto.getContent());
		
		return post;
	}

	@Override
	public PostDTO toDto(Post entity) {
		PostDTO dto = new PostDTO();
		
		dto.setId(entity.getId());
		dto.setHeading(entity.getHeading());
		dto.setSubHeading(entity.getSubHeading());
		dto.setContent(entity.getContent());
		dto.setUrlImage(entity.getUrlImage());
		dto.setDateCreate(entity.getDateCreate());
		
		return dto;
	}

	@Override
	public List<PostDTO> toDTOs(List<Post> entities) {
		List<PostDTO> dtos = new ArrayList<PostDTO>();
		entities.forEach((p)->{
			PostDTO dto = toDto(p);
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public List<Post> toEntities(List<PostDTO> dtos) {
		List<Post> entitys = new ArrayList<>();
		dtos.forEach((dto)->{
			Post p = toEntity(dto);
			entitys.add(p);
		});
		
		return entitys;
	}

	@Override
	public Post toEntityFromId(Long id) {
		return null;
	}
	
}
