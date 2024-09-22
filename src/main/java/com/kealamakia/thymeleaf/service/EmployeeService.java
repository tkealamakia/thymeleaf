package com.kealamakia.thymeleaf.service;

import com.kealamakia.thymeleaf.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
  List<Employee> getAllEmployees();
  void saveEmployee(Employee employee);
  Employee getEmployee(Long id);
  void deleteEmployee(Long id);
  Page<Employee> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
