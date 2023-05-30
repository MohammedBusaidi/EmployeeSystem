package com.EmployeeSystem.EmployeeSystem.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAll")
//    @PreAuthorize("hasRole('USER')")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/getById/{employeeId}")
//    @PreAuthorize("hasRole('USER')")
    public Employee getById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/create")
//    @PreAuthorize("hasRole('USER')")
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping(value = "/update")
//    @PreAuthorize("hasRole('USER')")
    public Employee updateEmployee(@RequestParam Long employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/delete/{employeeId}")
//    @PreAuthorize("hasRole('USER')")
    public String deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteById(employeeId);
        return "Course with ID " + employeeId + " has been deleted";
    }

}