package com.example.hr_manage.service;

import com.example.hr_manage.entity.Employee;
import com.example.hr_manage.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Employee> searchByName(String name) {
        return repository.findByEmployeeNameContainingIgnoreCase(name);
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }

    public Employee updateEmployee(String id, Employee updated) {
        Optional<Employee> existing = repository.findById(id);
        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setEmployeeName(updated.getEmployeeName());
            emp.setBirthday(updated.getBirthday());
            emp.setPhoneNumber(updated.getPhoneNumber());
            emp.getClass(updated.getEmail());
            return repository.save(emp);
        }
        return null;
    }
}
