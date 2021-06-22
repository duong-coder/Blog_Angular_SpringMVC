package com.dependency.inject.stack.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.repository.AccountRepository;
import com.dependency.inject.stack.service.AccountService;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.mapper.EntityMapper;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private EntityMapper<Account, AccountDTO, String> accountMapper;
	
	@Override
	public AccountDTO findById(String id) {
		Optional<Account> entityOp = accountRepository.findById(id);
		if(entityOp.isPresent()) {
			return accountMapper.toDTO(entityOp.get());
		}
		
		return null;
	}

}
