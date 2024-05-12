package com.example.employee.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier for the employee

    @Column(name = "employeename")
    private String employeeName; // Name of the employee

    @Column(name = "email")
    private String email; // Email address of the employee

    @Column(name = "department")
    private String department; // Department where the employee works

    // Default constructor required by Hibernate
    public Employee() {
    }

    // Constructor to initialize an Employee object with provided values
    public Employee(int id, String employeeName, String email, String department) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.department = department;
    }

    // Getter for retrieving the ID of the employee
    public int getId() {
        return id;
    }

    // Setter for setting the ID of the employee
    public void setId(int id) {
        this.id = id;
    }

    // Getter for retrieving the name of the employee
    public String getEmployeeName() {
        return employeeName;
    }

    // Setter for setting the name of the employee
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // Getter for retrieving the email address of the employee
    public String getEmail() {
        return email;
    }

    // Setter for setting the email address of the employee
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for retrieving the department of the employee
    public String getDepartment() {
        return department;
    }

    // Setter for setting the department of the employee
    public void setDepartment(String department) {
        this.department = department;
    }
}