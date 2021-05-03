package com.dependency.inject.stack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dependency.inject.stack.domain.Post;
import com.dependency.inject.stack.service.dto.PostDTO;

@Service
public interface PostService {
	void insert(PostDTO dto);
	
	void update(PostDTO dto);
	
	void delete(int id);
	
	PostDTO findById(int id);
	
	List<PostDTO> getAll();
	
	List<PostDTO> getAllById(String phonenumber);
}
