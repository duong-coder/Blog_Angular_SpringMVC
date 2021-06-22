package com.dependency.inject.stack.service;

import org.springframework.stereotype.Service;

import com.dependency.inject.stack.service.dto.AccountDTO;

@Service
public interface AccountService {
	AccountDTO findById(String id);
}
