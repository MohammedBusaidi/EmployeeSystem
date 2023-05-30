package com.EmployeeSystem.EmployeeSystem.Employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "get")
    @PreAuthorize("hasRole('USER')")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping(value = "getById")
    @PreAuthorize("hasRole('USER')")
    public Employee getById(@RequestParam Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping(value = "create")
    @PreAuthorize("hasRole('USER')")
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping(value = "update")
    @PreAuthorize("hasRole('USER')")
    public Employee updateEmployee(@RequestParam Long employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("deleteById")
    @PreAuthorize("hasRole('USER')")
    public void deleteEmployee(@RequestParam Long employeeId) {
        employeeService.deleteById(employeeId);
    }

}