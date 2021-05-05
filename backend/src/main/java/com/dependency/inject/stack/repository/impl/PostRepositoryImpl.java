package com.dependency.inject.stack.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Account;
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
	

	@Override
	public List<Post> getAllById(String phonenumber) {
		List<Post> posts = new ArrayList<Post>();
		Session session = sessionFactory.getCurrentSession() != null ? sessionFactory.getCurrentSession() : sessionFactory.openSession();
		try {
			String hql = "select p from Post p where p.account.phonenumber = :phonenumber";
			Query<Post> query = session.createQuery(hql, Post.class);
			query.setParameter("phonenumber", phonenumber);
			
			posts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return posts;
	}

}
