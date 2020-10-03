//package com.dependency.inject.stack.repository;
//
//import com.dependency.inject.stack.domain.Authority;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
///**
// * The interface Authority repository.
// */
//@Repository
//public interface AuthorityRepository extends JpaRepository<Authority, Long> {
//
//    /**
//     * Exists by name boolean.
//     *
//     * @param name the name
//     * @return the boolean
//     */
//    Boolean existsByName(String name);
//
//    /**
//     * Find by name authority.
//     *
//     * @param name the name
//     * @return the authority
//     */
//    Authority findByName(String name);
//
//}