package com.EmployeeSystem.EmployeeSystem.Employee;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public Employee findById(UUID employeeId) {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id : " + employeeId);
        }
        return employee;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public String deleteById(UUID employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee Deleted: " + employeeId;

    }
}
