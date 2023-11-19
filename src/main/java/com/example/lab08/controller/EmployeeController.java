package com.example.lab08.controller;

import com.example.lab08.entity.Employee;
import com.example.lab08.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/Lab8/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/Lab8/add")
    @Transactional
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        System.out.println(employee);
        return "redirect:/Lab8/";
    }

    @GetMapping("/Lab8/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/Lab8/edit/{id}")
    public String editEmployee(@PathVariable Long id, @ModelAttribute Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            // Cập nhật thông tin nhân viên
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setAddress(updatedEmployee.getAddress());
            employee.setPhone(updatedEmployee.getPhone());
            employeeRepository.save(employee);
        }
        return "redirect:/Lab8/";
    }

    @PostMapping("/Lab8/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/Lab8/";
    }

    @PostMapping("/Lab8/delete-multiple")
    @Transactional
    @ResponseBody
    public String deleteMultipleEmployees(@RequestBody List<Long> employeeIds) {
        for (Long employeeId : employeeIds) {
            employeeRepository.deleteById(employeeId);
        }
        return "redirect:/Lab8/";
    }
}

