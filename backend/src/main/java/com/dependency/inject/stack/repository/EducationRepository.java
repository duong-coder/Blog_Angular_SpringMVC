package com.dependency.inject.stack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Education;

@Repository
@Transactional
public interface EducationRepository extends JpaRepository<Education, Integer>{
//	void insert(Post post);
//	
//	void update(Post post);
	
	@Modifying
	@Query(value = "UPDATE Education e SET e.sortIndex = ?1 WHERE e.id = ?1")
	void setSortIndex(int id);
//	
//	void delete(int id);
//	
//	Post findById(int id);
//	
//	List<Post> getAll();
//
	@Query(value = "SELECT e FROM Education e WHERE e.account.username = ?1 ORDER BY e.sortIndex DESC")
	List<Education> findAllByAccountId(String id);
	
	@Query(value = "SELECT COUNT(e) FROM Education e WHERE e.account.username = ?1")
	long countByAccountId(String id);
}
