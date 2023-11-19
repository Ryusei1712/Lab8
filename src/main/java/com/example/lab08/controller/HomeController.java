package com.example.lab08.controller;

import com.example.lab08.entity.Employee;
import com.example.lab08.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/Lab8/")
    public String home(Model model) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Order.asc("id")));
        model.addAttribute("employees", employees);
        return "index";
    }
    @GetMapping("/Lab8/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/Lab8/contact")
    public String processContactForm(@RequestParam String name, @RequestParam String email, @RequestParam String address, @RequestParam String phone, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("address", address);
        model.addAttribute("phone", phone);
        return "contactResult";
    }

    @GetMapping("/Lab8/about")
    @ResponseBody
    public String about() {
        return "About this site";
    }

    @RequestMapping(value = "/Lab8/contact", method = {RequestMethod.PUT, RequestMethod.DELETE})
    @ResponseBody
    public String handleUnsupportedMethod() {
        return "Unsupported HTTP method for /contact";
    }

    @RequestMapping(value = "/Lab8/about", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @ResponseBody
    public String handleUnsupportedMethodAbout() {
        return "Unsupported HTTP method for /about";
    }

    @RequestMapping("/**")
    @ResponseBody
    public String handleInvalidPath() {
        return "Invalid Path";
    }
}


