//package com.dependency.inject.stack.web.rest;
//
//import com.dependency.inject.stack.common.StringUtils;
//import com.dependency.inject.stack.domain.User;
//import com.dependency.inject.stack.service.EmailService;
//import com.dependency.inject.stack.service.UserService;
//import com.dependency.inject.stack.service.dto.UserDTO;
//import com.dependency.inject.stack.web.rest.vm.ExistsResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.persistence.EntityNotFoundException;
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static com.dependency.inject.stack.common.ResourcesConstants.*;
//
///**
// * The type User resources.
// */
//@RestController
//@RequestMapping(RESOURCE_API)
//public class UserResources {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    /**
//     * Gets all users.
//     *
//     * @param page the page
//     * @param size the size
//     * @return the all users
//     */
//    @GetMapping(USER_MAPPING)
//    public ResponseEntity<List<UserDTO>> getAllUsers(
//            @RequestParam("page") int page, @RequestParam("size") int size) {
//        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "lastName"));
//        Pageable pageable = new PageRequest(page, size, sort);
//
//        Page<UserDTO> Users = userService.findAll(pageable);
//
//        return ResponseEntity.ok(Users.getContent());
//    }
//
//    /**
//     * Create user response entity.
//     *
//     * @param dto the dto
//     * @return the response entity
//     */
//    @PostMapping(USER_MAPPING)
//    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto) {
//        if (dto.getId() != null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        return Optional.ofNullable(userService.save(dto))
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//    /**
//     * Update user response entity.
//     *
//     * @param dto the dto
//     * @return the response entity
//     */
//    @PutMapping(USER_MAPPING)
//    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO dto) {
//        if (dto.getId() == null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        return Optional.ofNullable(userService.save(dto))
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//    /**
//     * Gets user by id.
//     *
//     * @param id the id
//     * @return the user by id
//     */
//    @GetMapping(USER_MAPPING + RESOURCE_MAPPING_ID)
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
//        return userService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//    /**
//     *
//     * @param email
//     * @return
//     */
//    @GetMapping(USER_MAPPING + "/email" + RESOURCE_MAPPING_EMAIL)
//    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
//        return ResponseEntity.ok(new ExistsResponse(this.userService.existsByEmail(email)));
//    }
//
//    /**
//     * KhÃ´i phá»¥c máº­t kháº©u
//     * @param email
//     * @return
//     * @throws MessagingException
//     */
//    @GetMapping("/users/recover")
//    public ResponseEntity<?> recoverPassword(@RequestParam String email) throws MessagingException {
//        Optional<UserDTO> userOptional = this.userService.findByEmail(email);
//        if(!userOptional.isPresent()) {
//            throw new EntityNotFoundException("Ä�á»‹a chá»‰ email: " + email + " khÃ´ng tá»“n táº¡i !");
//        }
//        UserDTO user = userOptional.get();
//        String password = StringUtils.generatePassayPassword();
//        String token = UUID.randomUUID().toString();
//        MimeMessage mimeMessage = null;
//        mimeMessage = emailService.constructResetTokenEmailForgot("",
//                token, password, user.getEmail(), user.getFirstName(), user.getLastName());
//        mailSender.send(mimeMessage);
//        user.setPassword(passwordEncoder.encode(password));
//        userService.save(user);
//        return ResponseEntity.ok().build();
//    }
//
//    /**
//     *
//     * @param phone
//     * @return
//     */
//    @GetMapping(USER_MAPPING + "/phone" + RESOURCE_MAPPING_PHONE)
//    public ResponseEntity<?> getUserByPhone(@PathVariable String phone) {
//        return ResponseEntity.ok(new ExistsResponse(this.userService.existsByPhone(phone)));
//    }
//
//    /**
//     * Delete user by id response entity.
//     *
//     * @param id the id
//     * @return the response entity
//     */
//    @DeleteMapping(USER_MAPPING + RESOURCE_MAPPING_ID)
//    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
//        userService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//}