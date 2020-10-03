//package com.dependency.inject.stack.repository;
//
//import com.dependency.inject.stack.domain.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
///**
// * The interface User repository.
// */
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    /**
//     * Find by phone user.
//     *
//     * @param phone the phone
//     * @return the user
//     */
//    User findByPhone(String phone);
//
//    /**
//     * Find by email optional.
//     *
//     * @param email the email
//     * @return the optional
//     */
//    Optional<User> findByEmail(String email);
//
//    /**
//     * Exists by phone boolean.
//     *
//     * @param phone the phone
//     * @return the boolean
//     */
//    boolean existsByPhone(String phone);
//
//    /**
//     * Exists by email boolean.
//     *
//     * @param email the email
//     * @return boolean
//     */
//    boolean existsByEmail(String email);
//
//
//}
