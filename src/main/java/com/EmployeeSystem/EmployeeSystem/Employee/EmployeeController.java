package com.EmployeeSystem.EmployeeSystem.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/getById/{employeeId}")
    public ResponseEntity<Employee> getById(@PathVariable("employeeId") Long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addEmployee")
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/activate/{employeeId}")
    public ResponseEntity<String> activateEmployee(@PathVariable Long employeeId) {
        employeeService.activateEmployee(employeeId);
        String message = "Employee with ID:9 " + employeeId + " has been reactivated.";
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deActivate/{employeeId}")
    public ResponseEntity<String> deActivateEmployee(@PathVariable Long employeeId) {
        employeeService.deActivateEmployee(employeeId);
        String message = "Employee with ID: " + employeeId + " has been deActivated.";
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Employee with ID: " + employeeId + " has been deleted.";

    }

}