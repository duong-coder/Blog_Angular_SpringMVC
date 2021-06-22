package com.dependency.inject.stack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dependency.inject.stack.service.dto.PostDTO;

@Service
public interface PostService {
	void insert(PostDTO dto);
	
	void update(PostDTO dto);
	
	void delete(int id);
	
	PostDTO findById(int id);
	
	List<PostDTO> findAll();
	
	List<PostDTO> findAllByAccountId(String id);
}
