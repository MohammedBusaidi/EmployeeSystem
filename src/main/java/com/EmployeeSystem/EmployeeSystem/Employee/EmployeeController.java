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
    public ResponseEntity<APICustomResponse> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return createResponse(
                Map.of("employees", employees),
                "List of all employees",
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
                "Employee has been created successfully",
                CREATED);
    }

    @PostMapping("/activate/{id}")
    public ResponseEntity<APICustomResponse> activateEmployee(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.activateEmployee(employeeId);
        return createResponse(
                Map.of("employee", employee),
                "Employee with ID: " + employeeId + " has been Re-Activated",
                CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<APICustomResponse> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
        return createResponse(
                null,
                "Employee has been updated successfully",
                OK);
    }

    @DeleteMapping("/deActivate/{id}")
    public ResponseEntity<APICustomResponse> deActivateEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deActivateEmployee(employeeId);
        return createResponse(
                null,
                "Employee with ID: " + employeeId + " has been De-Activated",
                OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APICustomResponse> deleteEmployee(
            @PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return createResponse(
                null,
                "Employee with ID: " + employeeId + " has been deleted successfully",
                OK);
    }

}