package com.EmployeeSystem.EmployeeSystem.Employee;

import com.EmployeeSystem.EmployeeSystem.Employee.Employee;
import com.EmployeeSystem.EmployeeSystem.Employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {
   final EmployeeRepository employeeRepository;

   public Employee findById(UUID employeeId) {
       return employeeRepository.findById(employeeId).get();
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
