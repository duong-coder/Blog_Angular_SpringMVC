package com.dependency.inject.stack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Post;
import com.dependency.inject.stack.repository.PostRepository;
import com.dependency.inject.stack.service.PostService;
import com.dependency.inject.stack.service.dto.PostDTO;
import com.dependency.inject.stack.service.mapper.EntityMapper;

@Service
@Transactional
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private EntityMapper<Post, PostDTO, Integer> postMapper;
	
	@Override
	public void insert(PostDTO dto) {
		if(dto != null) {
			Post post = postMapper.toEntity(dto);
			
			postRepository.save(post);
		}
	}

	@Override
	public void update(PostDTO dto) {
		if(dto != null) {
			Post post = postMapper.toEntity(dto);
			
			postRepository.save(post);
		}
	}

	@Override
	public void delete(int id) {
		boolean isExist = postRepository.existsById(id);
		if(isExist) {
			postRepository.deleteById(id);
		}
	}

	@Override
	public PostDTO findById(int id) {
		Optional<Post> postOp = postRepository.findById(id);
		if(postOp.isPresent()) {
			return postMapper.toDTO(postOp.get());
		}
		
		return null;
	}

	@Override
	public List<PostDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PostDTO> findAllByAccountId(String id) {
		List<Post> posts = postRepository.findAllByAccountId(id);
		List<PostDTO> postDTOs = new ArrayList<>();
		
 		if(posts != null && !posts.isEmpty()) {
			postDTOs = postMapper.toDTOs(posts);
		}
		
		return postDTOs;
	}
}
