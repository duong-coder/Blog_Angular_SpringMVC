package com.dependency.inject.stack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Account;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, String>{
	@Query(value = "SELECT new Account(a.github, a.facebook, a.twitter) FROM Account a WHERE a.username = ?1")
	Account getLinkSocialNetworkById(String id);
}
