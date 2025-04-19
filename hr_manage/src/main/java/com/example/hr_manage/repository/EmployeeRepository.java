package com.example.hr_manage.repository;

import com.example.hr_manage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByEmployeeNameContainingIgnoreCase(String name);

    Optional<Employee> findById(String id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(String id);
}