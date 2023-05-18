package com.EmployeeSystem.EmployeeSystem.Employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor // Is this needed?
@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository; //If this is not autowired than how it is initialized?

    public Employee findById(UUID employeeId) {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = null; // instead of this use Optional properly
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id : " + employeeId); // exceptions are not supposed to be used like this
            // data validation should happen in controller rather than in serviece
        }
        return employee;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll(); // directly returning this is not advisable
        // remove inactive data if you are returning it
    }

    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee); // saving data before validating it is not advisable
        return employee;
    }

    public String deleteById(UUID employeeId) {
        employeeRepository.deleteById(employeeId); // dont delete data make it inactive
        return "Employee Deleted: " + employeeId;

    }
}
