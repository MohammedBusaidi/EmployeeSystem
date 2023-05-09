package com.EmployeeSystem.EmployeeSystem.Employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;
//    @GetMapping()
//    public List<Employee> getAll() {
//        return employeeService.getAll();
//    }
    @GetMapping("{id}")
    public Employee getById(@PathVariable ("id") UUID employeeId) {
        return employeeService.findById(employeeId);
    }
    @PostMapping()
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable ("id") UUID employeeId) {
        return employeeService.deleteById(employeeId);
    }
}
