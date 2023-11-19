package com.example.lab08.service;

import com.example.lab08.entity.Employee;
import com.example.lab08.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeInitializationService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void initializeEmployees() {
        Employee employee1 = new Employee(null,"Thomas Hardy", "thomashardy@mail.com", "89 Chiaroscuro Rd, Portland, USA", "(171) 555-2222");
        Employee employee2 = new Employee(null,"Dominique Perrier", "dominiqueperrier@mail.com", "Obere Str. 57, Berlin, Germany", "(313) 555-5735");
        Employee employee3 = new Employee(null,"Catherine Dempsey", "catherinedempsey@mail.com", "12 Howard St, London, UK", "(516) 555-6258");
        Employee employee4 = new Employee(null,"John Smith", "johnsmith@mail.com", "123 Main St, New York, USA", "(212) 555-7890");
        Employee employee5 = new Employee(null,"Sophie Turner", "sophieturner@mail.com", "45 Park Lane, Los Angeles, USA", "(323) 555-4567");

        employeeRepository.saveAll(List.of(employee1, employee2, employee3,employee4,employee5));
    }
}
