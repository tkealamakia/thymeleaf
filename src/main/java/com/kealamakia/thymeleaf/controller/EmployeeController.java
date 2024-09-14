package com.kealamakia.thymeleaf.controller;

import com.kealamakia.thymeleaf.model.Employee;
import com.kealamakia.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public String viewHomePage(Model model) {
    return findPaginated(1, model);
  }

  @GetMapping("/showNewEmployeeForm")
  public String showNewEmployeeForm(Model model) {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);
    return "new_employee";
  }

  @PostMapping("/saveEmployee")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    employeeService.saveEmployee(employee);
    return "redirect:/";
  }

  @GetMapping("/editEmployee/{id}")
  public String editEmployee(Model model, @PathVariable Long id) {
    Employee employee = employeeService.getEmployee(id);
    model.addAttribute("employee", employee);
    return "new_employee";
  }

  @GetMapping("/deleteEmployee/{id}")
  public String deleteEmployee(Model model, @PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return "redirect:/";
  }

  @GetMapping("/page/{pageNo}")
  public String findPaginated(@PathVariable int pageNo, Model model) {
    int pageSize = 5;

    Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
    List<Employee> listEmployees = page.getContent();
    model.addAttribute("currentPage", pageNo);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    model.addAttribute("listEmployees", listEmployees);
    return "index";
  }
}
