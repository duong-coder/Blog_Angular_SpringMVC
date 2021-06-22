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
public class PostMapper implements EntityMapper<Post, PostDTO, Integer>{
	@Autowired
	private EntityMapper<Account, AccountDTO, String> accountMapper;
	
	@Override
	public Post toEntity(PostDTO dto) {
		Post post = new Post();
		
		post.setId(dto.getId());
		post.setHeading(dto.getHeading());
		post.setSubHeading(dto.getSubHeading());
		post.setUrlImage(dto.getUrlImage());
		post.setDateCreate(dto.getDateCreate());
		post.setContent(dto.getContent());
		
		AccountDTO accountDTO = dto.getAccountDTO();
		if(accountDTO != null) {
			Account account = ((AccountMapper) accountMapper).toEntityFromId(accountDTO.getUsername());
			
			post.setAccount(account);
		}

		return post;
	}

	@Override
	public PostDTO toDTO(Post entity) {
		PostDTO dto = new PostDTO();
		
		dto.setId(entity.getId());
		dto.setHeading(entity.getHeading());
		dto.setSubHeading(entity.getSubHeading());
		dto.setContent(entity.getContent());
		dto.setUrlImage(entity.getUrlImage());
		dto.setDateCreate(entity.getDateCreate());
		
		Account account = entity.getAccount();
		if(account != null) {
			AccountDTO accountDTO = accountMapper.toDTOFromId(account.getUsername());
			dto.setAccountDTO(accountDTO);
		}
		
		return dto;
	}

	@Override
	public List<PostDTO> toDTOs(List<Post> entities) {
		List<PostDTO> dtos = new ArrayList<PostDTO>();
		entities.forEach((p)->{
			PostDTO dto = toDTO(p);
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
	public Post toEntityFromId(Integer id) {
		Post post = new Post();
		post.setId(id);
		
		return post;
	}
	
	@Override
	public PostDTO toDTOFromId(Integer id) {
		PostDTO dto = new PostDTO();
		dto.setId(id);
		
		return dto;
	}
}
