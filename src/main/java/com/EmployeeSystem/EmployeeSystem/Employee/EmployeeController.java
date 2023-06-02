package com.EmployeeSystem.EmployeeSystem.Employee;

import com.EmployeeSystem.EmployeeSystem.Exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController extends GenericController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getAll() {
        List<Employee> employees = employeeService.getAll();
        return createResponse(
                Map.of("List of All Employees", employees),
                "Employees",
                OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<APICustomResponse> getById(
            @PathVariable("id") Long employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        return createResponse(
                Map.of("employee", employee),
                "Employee has been fetched successfully",
                OK);
    }

    @PostMapping
    public ResponseEntity<APICustomResponse> createEmployee(@RequestBody Employee employee) {
        Long employeeId = employeeService.createEmployee(employee);
        return createResponse(
                Map.of("employee_Id", employeeId),
                "Employee have been created",
                CREATED);
    }

    @PostMapping("/activate/{employeeId}")
    public ResponseEntity<String> activateEmployee(@PathVariable Long employeeId) {
        employeeService.activateEmployee(employeeId);
        String message = "Employee with ID: " + employeeId + " has been reactivated.";
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