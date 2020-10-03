//package com.dependency.inject.stack.service.impl;
//
//import com.dependency.inject.stack.domain.Authority;
//import com.dependency.inject.stack.domain.User;
//import com.dependency.inject.stack.repository.AuthorityRepository;
//import com.dependency.inject.stack.repository.UserRepository;
//import com.dependency.inject.stack.service.UserService;
//import com.dependency.inject.stack.service.dto.DoctorDTO;
//import com.dependency.inject.stack.service.dto.NurseDTO;
//import com.dependency.inject.stack.service.dto.PatientDTO;
//import com.dependency.inject.stack.service.dto.UserDTO;
//import com.dependency.inject.stack.service.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.*;
//
//import static com.dependency.inject.stack.common.AuthoritiesConstants.*;
//import static com.dependency.inject.stack.common.UserConstants.ACTIVE_ACCOUNT;
//import static com.dependency.inject.stack.common.UserConstants.IN_ACTIVE_ACCOUNT;
//
///**
// * The type User service.
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthorityRepository authorityRepository;
//
//    /**
//     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
//     *
//     * @param pageable
//     * @return a page of entities
//     */
//    @Override
//    public Page<UserDTO> findAll(Pageable pageable) {
//        return userRepository.findAll(pageable).map(userMapper::toDto);
//    }
//
//
//    /**
//     * Exists by phone boolean.
//     *
//     * @param phone the phone
//     * @return the boolean
//     */
//    @Override
//    public boolean existsByPhone(String phone) {
//        return userRepository.existsByPhone(phone);
//    }
//
//    /**
//     *
//     * @param email
//     * @return
//     */
//    @Override
//    public boolean existsByEmail(String email) {
//        return userRepository.existsByEmail(email);
//    }
//
//    /**
//     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
//     * entity instance completely.
//     *
//     * @param dto must not be {@literal null}.
//     * @return the saved entity; will never be {@literal null}.
//     */
//    @Override
//    public UserDTO save(UserDTO dto) {
//        User entity = userMapper.toEntity(dto);
//
//        return Optional.ofNullable(userRepository.save(entity)).map(userMapper::toDto).orElse(null);
//    }
//
//    /**
//     * Save user dto.
//     *
//     * @param dto the dto
//     * @return the user dto
//     */
//    @Override
//    public User save(DoctorDTO dto) {
//        User user = new User();
//        TimeZone zone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
//        Instant instantNow = Calendar.getInstance(zone).getTime().toInstant().plus(7, ChronoUnit.HOURS);
//        if (dto.getId() == null) {
//            user.setId(dto.getUserId());
//            user.setCreatedDate(instantNow);
//            user.setActivated(IN_ACTIVE_ACCOUNT);
//            user.setAddress(dto.getAddress());
//
//            List<Authority> authorities = new ArrayList<>();
//            authorities.add(authorityRepository.findByName(AUTHORITY_DOCTOR));
//            authorities.add(authorityRepository.findByName(AUTHORITY_USER));
//
//            user.setAuthorities(authorities);
//            user.setBirthday(dto.getBirthday());
//            user.setEmail(dto.getEmail());
//            user.setImageUrl(dto.getImageUrl());
//            user.setPhone("0".concat(dto.getPhone()));
//            user.setGender(dto.getGender());
//            user.setFirstName(dto.getFirstName());
//            user.setLastName(dto.getLastName());
//            user.setPassword(dto.getPassword());
//        } else {
//            user = userRepository.findById(dto.getUserId()).get();
//            user.setLastName(dto.getLastName());
//            user.setFirstName(dto.getFirstName());
//            user.setGender(dto.getGender());
//            user.setAddress(dto.getAddress());
//            user.setEmail(dto.getEmail());
//            user.setLastUpdatedDate(instantNow);
//        }
//
//        return userRepository.save(user);
//    }
//
//    /**
//     * Save user.
//     *
//     * @param dto the dto
//     * @return the user
//     */
//    @Override
//    public User save(NurseDTO dto) {
//        User user = new User();
//        TimeZone zone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
//        Instant instantNow = Calendar.getInstance(zone).getTime().toInstant().plus(7, ChronoUnit.HOURS);
//        if (dto.getId() == null) {
//            user.setId(dto.getUserId());
//            user.setCreatedDate(instantNow);
//            user.setActivated(IN_ACTIVE_ACCOUNT);
//            user.setAddress(dto.getAddress());
//
//            List<Authority> authorities = new ArrayList<>();
//            authorities.add(authorityRepository.findByName(AUTHORITY_NURSE));
//            authorities.add(authorityRepository.findByName(AUTHORITY_USER));
//
//            user.setAuthorities(authorities);
//            user.setBirthday(dto.getBirthday());
//            user.setEmail(dto.getEmail());
//            user.setImageUrl(dto.getImageUrl());
//            user.setPhone("0".concat(dto.getPhone()));
//            user.setGender(dto.getGender());
//            user.setFirstName(dto.getFirstName());
//            user.setLastName(dto.getLastName());
//            user.setPassword(dto.getPassword());
//        } else {
//            user = userRepository.findById(dto.getUserId()).get();
//            user.setLastName(dto.getLastName());
//            user.setFirstName(dto.getFirstName());
//            user.setGender(dto.getGender());
//            user.setAddress(dto.getAddress());
//            user.setEmail(dto.getEmail());
//            user.setLastUpdatedDate(instantNow);
//        }
//
//        return userRepository.save(user);
//    }
//
//    /**
//     * Save user dto.
//     *
//     * @param dto the dto
//     * @return the user dto
//     */
//    @Override
//    public User save(PatientDTO dto) {
//        User user = new User();
//        TimeZone zone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
//        Instant instantNow = Calendar.getInstance(zone).getTime().toInstant().plus(7, ChronoUnit.HOURS);
//
//        if (dto.getId() == null) {
//            user.setId(dto.getUserId());
//            user.setCreatedDate(instantNow);
//            user.setActivated(IN_ACTIVE_ACCOUNT);
//            user.setAddress(dto.getAddress());
//
//            List<Authority> authorities = new ArrayList<>();
//            authorities.add(authorityRepository.findByName(AUTHORITY_PATIENT));
//            authorities.add(authorityRepository.findByName(AUTHORITY_USER));
//
//            user.setAuthorities(authorities);
//            user.setBirthday(dto.getBirthday());
//            user.setEmail(dto.getEmail());
//            user.setImageUrl(dto.getImageUrl());
//            user.setPhone("0".concat(dto.getPhone()));
//            user.setGender(dto.getGender());
//            user.setFirstName(dto.getFirstName());
//            user.setLastName(dto.getLastName());
//            user.setPassword(dto.getPassword());
//        } else {
//            user = userRepository.findById(dto.getUserId()).get();
//            user.setLastName(dto.getLastName());
//            user.setFirstName(dto.getFirstName());
//            user.setGender(dto.getGender());
//            user.setAddress(dto.getAddress());
//            user.setEmail(dto.getEmail());
//            user.setLastUpdatedDate(instantNow);
//        }
//
//        return userRepository.save(user);
//    }
//
//    /**
//     * Retrieves an entity by its id.
//     *
//     * @param aLong must not be {@literal null}.
//     * @return the entity with the given id or {@literal Optional#empty()} if none found
//     * @throws IllegalArgumentException if {@code id} is {@literal null}.
//     */
//    @Override
//    public Optional<UserDTO> findById(Long aLong) {
//        return userRepository.findById(aLong).map(userMapper::toDto);
//    }
//
//    /**
//     * Retrieves an entity by its phone.
//     *
//     * @param phone must not be {@literal null}.
//     * @return the entity with the given phone or {@literal Optional#empty()} if none found
//     * @throws IllegalArgumentException if {@code phone} is {@literal null}.
//     */
//    @Override
//    public UserDTO findByPhone(String phone) {
//        return Optional.ofNullable(userRepository.findByPhone(phone)).map(userMapper::toDto).orElse(null);
//    }
//
//    @Override
//    public Optional<UserDTO> findByEmail(String email) {
//        return userRepository
//                    .findByEmail(email)
//                    .map(this.userMapper::toDto);
//    }
//
//
//    /**
//     * Returns whether an entity with the given id exists.
//     *
//     * @param aLong must not be {@literal null}.
//     * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
//     * @throws IllegalArgumentException if {@code id} is {@literal null}.
//     */
//    @Override
//    public boolean existsById(Long aLong) {
//        return userRepository.existsById(aLong);
//    }
//
//    /**
//     * Deletes the entity with the given id.
//     *
//     * @param aLong must not be {@literal null}.
//     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
//     */
//    @Override
//    public void deleteById(Long aLong) {
//        userRepository.deleteById(aLong);
//    }
//
//    /**
//     * Active user by id user dto.
//     *
//     * @param id the id
//     * @return the user dto
//     */
//    @Override
//    public UserDTO activeUserById(Long id) {
//        User user = userRepository.findById(id).get();
//        user.setActivated(ACTIVE_ACCOUNT);
//
//        return Optional.ofNullable(userRepository.save(user))
//                .map(userMapper::toDto)
//                .orElse(null);
//    }
//
//
//
//
//}
