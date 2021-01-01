package com.dependency.inject.stack.repository;

import org.springframework.stereotype.Repository;

import com.dependency.inject.stack.domain.Account;

@Repository
public interface AccountRepository {
	Account findByPhone(String phone);
}
