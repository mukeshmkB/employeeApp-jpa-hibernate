package com.example.employee.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.employee.service.EmployeeJpaService;
import com.example.employee.model.Employee;

// Controller class to handle HTTP requests related to employees
@RestController
public class EmployeeController {

   @Autowired
   public EmployeeJpaService employeeJpaService;

   // Endpoint to get all employees
   @GetMapping("/employees")
   public ArrayList<Employee> getEmployees() {
      return employeeJpaService.getEmployees();
   }

   // Endpoint to get an employee by ID
   @GetMapping("/employees/{employeeId}")
   public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
      return employeeJpaService.getEmployeeById(employeeId);
   }

   // Endpoint to add a new employee
   @PostMapping("/employees")
   public Employee addEmployee(@RequestBody Employee employee) {
      return employeeJpaService.addEmployee(employee);
   }

   // Endpoint to update an existing employee
   @PutMapping("/employees/{employeeId}")
   public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
      return employeeJpaService.updateEmployee(employeeId, employee);
   }

   // Endpoint to delete an employee by ID
   @DeleteMapping("/employees/{employeeId}")
   public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
      employeeJpaService.deleteEmployee(employeeId);
   }
}