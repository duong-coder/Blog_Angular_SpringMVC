package com.dependency.inject.stack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.Skill;

@Repository
@Transactional
public interface SkillRepository extends JpaRepository<Skill, Integer>{
//	void insert(Post post);
//	
//	void update(Post post);
//	
	@Modifying
	@Query(value = "UPDATE Skill s SET s.sortIndex = ?1 WHERE s.id = ?1")
	void setSortIndex(int id);
	
//	void delete(int id);
//	
//	Post findById(int id);
//	
//	List<Post> getAll();
//
	@Query(value = "SELECT s FROM Skill s WHERE s.account.username = ?1")
	List<Skill> findAllByAccountId(String id);
	
	@Query(value = "SELECT COUNT(s) FROM Skill s WHERE s.account.username = ?1")
	long countByAccountId(String id);
}
