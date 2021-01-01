package com.dependency.inject.stack.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.repository.AccountRepository;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account findByPhone(String phone) {
		Account ac = sessionFactory.getCurrentSession().get(Account.class, phone);
		
		return ac;
	}

}
