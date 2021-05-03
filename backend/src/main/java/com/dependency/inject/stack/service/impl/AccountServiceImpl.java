package com.dependency.inject.stack.service.impl;

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
	private EntityMapper<Account, AccountDTO> accountMapper;
	
	@Override
	public AccountDTO findByPhone(String phone) {
		Account entity = accountRepository.getAccountByPhone(phone);
		
		return accountMapper.toDto(entity);
	}

}
