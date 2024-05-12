package com.example.employee.repository;

import java.util.*; // Importing java.util package for ArrayList

import com.example.employee.model.Employee; // Importing the Employee model

// Interface for Employee repository
public interface EmployeeRepository {

    // Method to get all employees
    ArrayList<Employee> getEmployees();

    // Method to get an employee by ID
    Employee getEmployeeById(int employeeId);

    // Method to add a new employee
    Employee addEmployee(Employee employee);

    // Method to update an existing employee
    Employee updateEmployee(int employeeId, Employee employee);

    // Method to delete an employee
    void deleteEmployee(int employeeId);
}