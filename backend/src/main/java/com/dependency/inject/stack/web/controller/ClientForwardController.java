//package com.dependency.inject.stack.web.controller;
//
//import com.dependency.inject.stack.service.AppointmentService;
//import com.dependency.inject.stack.service.DepartmentService;
//import com.dependency.inject.stack.service.DoctorService;
//import com.dependency.inject.stack.service.PatientService;
//import com.dependency.inject.stack.service.dto.AppointmentDTO;
//import com.dependency.inject.stack.service.dto.DepartmentDTO;
//import com.dependency.inject.stack.service.dto.DoctorDTO;
//import com.dependency.inject.stack.service.dto.PatientDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
///**
// * The type Client forward controller.
// */
//@Controller
//public class ClientForwardController {
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @Autowired
//    private DepartmentService departmentService;
//    @Autowired
//    private AppointmentService appointmentService;
//
//    @Autowired
//    private PatientService patientService;
//    /**
//     * Default mapping string.
//     *
//     * @param model the model
//     * @return the string
//     */
//    @RequestMapping(value = {"/home/", "/", ""}, method = RequestMethod.GET)
//    public String showDepartment(Model model) {
//        model.addAttribute("department", departmentService.findAllByLimit());
//        model.addAttribute("doctors", doctorService.findAllByLimit());
//        List<DoctorDTO> listDoctor = doctorService.findAll();
//        model.addAttribute("doctorSize", listDoctor.size());
//        List<DepartmentDTO> listDepartment = departmentService.findAll();
//        model.addAttribute("departmentSize", listDepartment.size());
//        List<PatientDTO> listPatient = patientService.findAll();
//        model.addAttribute("patientSize", listPatient.size());
//        List<AppointmentDTO> listAppoiment = appointmentService.findAll();
//        model.addAttribute("appointmentSize", listAppoiment.size());
//        return "index";
//    }
//
//}
