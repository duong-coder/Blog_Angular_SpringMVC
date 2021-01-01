package com.dependency.inject.stack.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Post;
import com.dependency.inject.stack.repository.PostRepository;

@Repository
@Transactional
public class PostRepositoryImpl implements PostRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Post post) {
		sessionFactory.getCurrentSession().save(post);
	}

	@Override
	public void update(Post post) {
		sessionFactory.getCurrentSession().merge(post);
	}

	@Override
	public void delete(int id) {
		Post p =findById(id);
		if(p != null) {
			sessionFactory.getCurrentSession().delete(p);
		}
	}

	@Override
	public Post findById(int id) {
		Post p = (Post) sessionFactory.getCurrentSession().get(Post.class, id);
		
		return p;
	}
	

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
