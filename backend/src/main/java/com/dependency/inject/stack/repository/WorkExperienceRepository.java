package com.dependency.inject.stack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dependency.inject.stack.domain.WorkExperience;

@Repository
@Transactional
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer>{
//	void insert(Post post);
//	
//	void update(Post post);
//	
//	void delete(int id);
//	
//	Post findById(int id);
//	
//	List<Post> getAll();
//
	@Query(value = "SELECT we FROM Skill we WHERE we.account.username = ?1")
	List<WorkExperience> findAllByAccountId(String id);
}
