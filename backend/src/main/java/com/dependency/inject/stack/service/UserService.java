//package com.dependency.inject.stack.service;
//
//import com.dependency.inject.stack.domain.User;
//import com.dependency.inject.stack.service.dto.DoctorDTO;
//import com.dependency.inject.stack.service.dto.NurseDTO;
//import com.dependency.inject.stack.service.dto.PatientDTO;
//import com.dependency.inject.stack.service.dto.UserDTO;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.Optional;
//
///**
// * The interface User service.
// */
//public interface UserService {
//
//    /**
//     * Find all page.
//     *
//     * @param pageable the pageable
//     * @return the page
//     */
//    Page<UserDTO> findAll(Pageable pageable);
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
//     *
//     * @param email
//     * @return
//     */
//    boolean existsByEmail(String email);
//    /**
//     * Save user dto.
//     *
//     * @param dto the dto
//     * @return the user dto
//     */
//    UserDTO save(UserDTO dto);
//
//    /**
//     * Save user dto.
//     *
//     * @param dto the dto
//     * @return the user dto
//     */
//    User save(DoctorDTO dto);
//
//    /**
//     * Save user.
//     *
//     * @param dto the dto
//     * @return the user
//     */
//    User save(NurseDTO dto);
//
//    /**
//     * Save user dto.
//     *
//     * @param dto the dto
//     * @return the user dto
//     */
//    User save(PatientDTO dto);
//
//
//    /**
//     * Find by id optional.
//     *
//     * @param aLong the a long
//     * @return the optional
//     */
//    Optional<UserDTO> findById(Long aLong);
//
//    /**
//     * Find by phone user dto.
//     *
//     * @param phone the phone
//     * @return the user dto
//     */
//    UserDTO findByPhone(String phone);
//
//    Optional<UserDTO> findByEmail(String email);
//
//    /**
//     * Exists by id boolean.
//     *
//     * @param aLong the a long
//     * @return the boolean
//     */
//    boolean existsById(Long aLong);
//
//    /**
//     * Delete by id.
//     *
//     * @param aLong the a long
//     */
//    void deleteById(Long aLong);
//
//
//    /**
//     * Active user by id user dto.
//     *
//     * @param id the id
//     * @return the user dto
//     */
//    UserDTO activeUserById(Long id);
//
//
//
//}
