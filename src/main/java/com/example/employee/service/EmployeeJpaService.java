package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;

// Service class implementing EmployeeRepository interface
@Service
public class EmployeeJpaService implements EmployeeRepository {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository; // Autowiring EmployeeJpaRepository

    // Method to delete an employee by ID
    @Override
    public void deleteEmployee(int employeeId) {
        try {
            // Try to delete employee by ID
            employeeJpaRepository.deleteById(employeeId);
        } catch (Exception e) {
            // If deletion fails, throw 404 status exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Method to update an existing employee
    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        try {
            // Find employee by ID
            Employee newEmployee = employeeJpaRepository.findById(employeeId).get();

            // Update employee fields if provided
            if (employee.getEmployeeName() != null) {
                newEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (employee.getEmail() != null) {
                newEmployee.setEmail(employee.getEmail());
            }
            if (employee.getDepartment() != null) {
                newEmployee.setDepartment(employee.getDepartment());
            }

            // Save and return updated employee
            employeeJpaRepository.save(newEmployee);
            return newEmployee;
        } catch (Exception e) {
            // If employee not found, throw 404 status exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Method to add a new employee
    @Override
    public Employee addEmployee(Employee employee) {
        // Save and return added employee
        employeeJpaRepository.save(employee);
        return employee;
    }

    // Method to get an employee by ID
    @Override
    public Employee getEmployeeById(int employeeId) {
        try {
            // Find employee by ID
            Employee employee = employeeJpaRepository.findById(employeeId).get();
            return employee;
        } catch (Exception e) {
            // If employee not found, throw 404 status exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Method to get all employees
    @Override
    public ArrayList<Employee> getEmployees() {
        // Retrieve all employees from repository and convert to ArrayList
        List<Employee> employeeList = employeeJpaRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>(employeeList);
        return employees;
    }
}