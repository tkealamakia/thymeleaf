package com.kealamakia.thymeleaf.service;

import com.kealamakia.thymeleaf.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
  List<Employee> getAllEmployees();
}
