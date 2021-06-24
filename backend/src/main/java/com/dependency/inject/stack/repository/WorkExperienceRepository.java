package com.dependency.inject.stack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	@Modifying
	@Query(value = "update Education e set e.sortIndex = ?1 where e.id = ?1")
	void setSortIndex(int id);
//	
//	void delete(int id);
//	
//	Post findById(int id);
//	
//	List<Post> getAll();
//
	@Query(value = "SELECT we FROM WorkExperience we WHERE we.account.username = ?1 ORDER BY we.sortIndex DESC")
	List<WorkExperience> findAllByAccountId(String id);
}
