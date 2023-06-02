package com.EmployeeSystem.EmployeeSystem.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee findEmployeeById(Long employeeId);

    Long createEmployee(Employee employee);

    Employee updateEmployee(Long employeeId, Employee employee);

    void deActivateEmployee(Long employeeId);

    void activateEmployee(Long employeeId);

    void deleteEmployee(Long employeeId);

}
