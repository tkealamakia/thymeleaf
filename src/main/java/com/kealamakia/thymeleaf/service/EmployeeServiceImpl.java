package com.kealamakia.thymeleaf.service;

import com.kealamakia.thymeleaf.model.Employee;
import com.kealamakia.thymeleaf.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  public EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> getAllEmployees() {
    Employee employee1 = new Employee();
    employee1.setEmail("tkealamakia@gmail.com");
    employee1.setFirstName("Tom");
    employee1.setLastName("Kealamakia");
    Employee employee2 = new Employee();
    employee2.setEmail("steve@apple.com");
    employee2.setFirstName("Steve");
    employee2.setLastName("Jobs");
    return List.of(employee1, employee2);

//    return employeeRepository.findAll();
  }
}
