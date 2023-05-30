package com.EmployeeSystem.EmployeeSystem.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long employeeId) {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id : " + employeeId);
        }
        return employee;
    }

    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee employeeUpdate = employeeRepository.findById(employeeId).orElseThrow();
        employeeUpdate.setFirstName(employee.getFirstName());
        employeeUpdate.setLastName(employee.getLastName());
        employeeUpdate.setPassportNumber(employee.getPassportNumber());
        employeeUpdate.setPassportIssueDate(employee.getPassportIssueDate());
        employeeUpdate.setPassportExpiryDate(employee.getPassportExpiryDate());
        employeeUpdate.setVisaNumber(employee.getVisaNumber());
        employeeUpdate.setVisaIssueDate(employee.getVisaIssueDate());
        employeeUpdate.setVisaExpiryDate(employee.getVisaExpiryDate());
        return employeeRepository.save(employeeUpdate);
    }

    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
