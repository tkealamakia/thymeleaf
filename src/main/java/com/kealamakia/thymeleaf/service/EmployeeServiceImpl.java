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
    return employeeRepository.findAll();
  }

  @Override
  public void saveEmployee(Employee employee) {
    this.employeeRepository.save(employee);
  }
}
