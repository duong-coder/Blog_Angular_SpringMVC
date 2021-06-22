package com.dependency.inject.stack.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Account;

@Transactional
public interface AccountRepository extends JpaRepository<Account, String>{
//	Account getOnAccount(String id);
}
