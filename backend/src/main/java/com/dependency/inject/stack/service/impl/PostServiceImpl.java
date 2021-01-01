package com.dependency.inject.stack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Post;
import com.dependency.inject.stack.repository.PostRepository;
import com.dependency.inject.stack.service.PostService;
import com.dependency.inject.stack.service.dto.PostDTO;
import com.dependency.inject.stack.service.mapper.EntityMapper;
import com.dependency.inject.stack.service.mapper.PostMapper;

@Service
@Transactional
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private EntityMapper<Post, PostDTO> postMapper;
	
	@Override
	public void insert(PostDTO dto) {
		postRepository.insert(postMapper.toEntity(dto));
	}

	@Override
	public void update(PostDTO dto) {
		postRepository.update(postMapper.toEntity(dto));
		
	}

	@Override
	public void delete(int id) {
		postRepository.delete(id);
		
	}

	@Override
	public PostDTO findById(int id) {
		Post p = postRepository.findById(id);
		
		return postMapper.toDto(p);
	}

	@Override
	public List<PostDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
