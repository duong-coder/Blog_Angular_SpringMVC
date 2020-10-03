//package com.dependency.inject.stack.web.controller;
//
//import com.dependency.inject.stack.service.EmailService;
//import com.dependency.inject.stack.service.PatientService;
//import com.dependency.inject.stack.service.UserService;
//import com.dependency.inject.stack.service.dto.PatientDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.validation.Valid;
//
///**
// * The type Account controller.
// */
//@Controller
//@RequestMapping("/account")
//public class AccountController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PatientService patientService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    
//    @Autowired
//    private EmailService emailService;
//    
//    @Autowired
//    private JavaMailSender mailSender;
//    
//    /**
//     * Go to register string.
//     *
//     * @param model the model
//     * @return the string
//     */
//    @GetMapping(value = {"/register"})
//    public String goToRegister(ModelMap model) {
//        model.addAttribute("patientDTO", new PatientDTO());
//        return "register";
//    }
//
//    /**
//     * Register string.
//     *
//     * @param dto           the dto
//     * @param bindingResult the binding result
//     * @param model         the model
//     * @return the string
//     */
//    @PostMapping(value = {"/register"})
//    public String register(@Valid @ModelAttribute("patientDTO") PatientDTO dto, BindingResult bindingResult, ModelMap model) throws MessagingException {
//        boolean isExists = false;
//        if (userService.existsByPhone("0" + dto.getPhone().trim())) {
//            model.addAttribute("existPhone", "Số điện thoại đã tồn tại !");
//            isExists = true;
//        }
//        if (userService.existsByEmail(dto.getEmail().trim())) {
//            model.addAttribute("existEmail", "Email đã tồn tại !");
//            isExists = true;
//        }
//        if (isExists) {
//            model.addAttribute("patientDTO", dto);
//            return "/register";
//        } else {
//            PatientDTO patientDTO = new PatientDTO();
//            patientDTO.setFirstName(dto.getFirstName());
//            patientDTO.setLastName(dto.getLastName());
//            patientDTO.setPassword(passwordEncoder.encode(dto.getPassword()));
//            patientDTO.setCardId(dto.getCardId());
//            patientDTO.setInsuranceCardNumber(dto.getInsuranceCardNumber());
//            patientDTO.setPhone(dto.getPhone());
//            patientDTO.setEmail(dto.getEmail());
//            patientService.save(patientDTO);
//            MimeMessage mimeMessage = emailService.constructEmailWelcome("Kính chào", patientDTO.getEmail(), patientDTO.getLastName(), patientDTO.getFirstName());
//            mailSender.send(mimeMessage);
//            return "redirect:https://hdht-medical-management.herokuapp.com/";
//        }
//    }
//
//    /**
//     * Go to forgot string.
//     *
//     * @param model the model
//     * @return the string
//     */
//    @GetMapping(value = {"/forgot"})
//    public String goToForgot(ModelMap model) {
//        /* model.addAttribute("patientDTO", new PatientDTO());*/
//        return "forgot-password";
//    }
//
//    @GetMapping(value = {"/clientcheck/{phone}"})
//    @ResponseBody
//    public Integer checkPhoneClient(@PathVariable String phone) {
//        if (userService.existsByPhone(phone)) {
//            return 1;
//        }
//
//        return 0;
//    }
//
//}
