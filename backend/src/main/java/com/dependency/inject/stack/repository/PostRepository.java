package com.dependency.inject.stack.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dependency.inject.stack.domain.Post;

@Repository
public interface PostRepository {
	void insert(Post post);
	
	void update(Post post);
	
	void delete(int id);
	
	Post findById(int id);
	
	List<Post> getAll();

	List<Post> getAllById(String phonenumber);
}
