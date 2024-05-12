package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.employee.model.Employee; // Importing the Employee model

@Repository // Indicates that this interface is a Spring Data repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
    // EmployeeJpaRepository extends JpaRepository and provides Employee entity type
    // and ID type
}