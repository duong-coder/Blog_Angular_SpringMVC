//package com.dependency.inject.stack.web.controller;
//
//import com.dependency.inject.stack.service.DepartmentService;
//import com.dependency.inject.stack.service.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * The type Service controller.
// */
//@Controller
//@RequestMapping("/forgot-password")
//public class ForgotPassword {
//
//    @Autowired
//    private DepartmentService departmentService;
//
//    @Autowired
//    private DoctorService doctorService;
//
//    /**
//     * Go to service page string.
//     *
//     * @param model the model
//     * @return the string
//     */
//    @GetMapping(value = {"/", ""})
//    public String showDepartment(Model model) {
//        model.addAttribute("department",departmentService.findAll());
//        return "forgot-password";
//    }
//
//    /**
//     * Find doctor by depart string.
//     *
//     * @param model the model
//     * @param id    the id
//     * @return the string
//     */
//    @GetMapping(value = "showdepartbydoctor/{id}")
//    public String findDoctorByDepart(Model model, @PathVariable Long id){
//    model.addAttribute("doctorByDepartment", doctorService.findADoctorByDepart(id));
//
//        return "FacultyInformation";
//    }
//
//}
