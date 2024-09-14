package com.kealamakia.thymeleaf.service;

import com.kealamakia.thymeleaf.model.Employee;
import com.kealamakia.thymeleaf.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    employeeRepository.save(employee);
  }

  @Override
  public Employee getEmployee(Long id) {
    Optional<Employee> optional = employeeRepository.findById(id);
    Employee employee = null;
    if (optional.isPresent()) {
      employee = optional.get();
    } else {
      throw new RuntimeException("Employee not found for id :: " + id);
    }
    return employee;
  }

  @Override
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public Page<Employee> findPaginated(int pageNum, int pageSize) {
    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
    return employeeRepository.findAll(pageable);
  }
}
