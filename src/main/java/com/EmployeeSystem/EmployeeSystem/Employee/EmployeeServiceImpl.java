package com.EmployeeSystem.EmployeeSystem.Employee;

import com.EmployeeSystem.EmployeeSystem.Constants.Constants;
import com.EmployeeSystem.EmployeeSystem.Exception.EmployeeNotFoundException;
import com.EmployeeSystem.EmployeeSystem.Exception.ResourceNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository
                .findById(employeeId)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Long createEmployee(@NotNull Employee employee) {
        LocalDateTime now = LocalDateTime.now();
        employee.setVat(employee.getSalary() * Constants.vat);
        employee.setCreatedDate(now);
        employee.setActive(true);
        employeeRepository.save(employee);
        return employee.getEmployeeId();
    }

    public Employee updateEmployee(Long employeeId, Employee employee) throws EmployeeNotFoundException {
        LocalDateTime now = LocalDateTime.now();
        Employee employeeUpdate = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
        employeeUpdate.setFirstName(employee.getFirstName());
        employeeUpdate.setLastName(employee.getLastName());
        employeeUpdate.setPassportNumber(employee.getPassportNumber());
        employeeUpdate.setPassportIssueDate(employee.getPassportIssueDate());
        employeeUpdate.setPassportExpiryDate(employee.getPassportExpiryDate());
        employeeUpdate.setVisaNumber(employee.getVisaNumber());
        employeeUpdate.setVisaIssueDate(employee.getVisaIssueDate());
        employeeUpdate.setVisaExpiryDate(employee.getVisaExpiryDate());
        employeeUpdate.setDateOfEntryCountry(employee.getDateOfEntryCountry());
        employeeUpdate.setAirportOfDeparture(employee.getAirportOfDeparture());
        employeeUpdate.setCompanyName(employee.getCompanyName());
        employeeUpdate.setSrNumber(employee.getSrNumber());
        employeeUpdate.setPlaceOfWork(employee.getPlaceOfWork());
        employeeUpdate.setStartOfContract(employee.getStartOfContract());
        employeeUpdate.setEndOfContract(employee.getEndOfContract());
        employeeUpdate.setSalary(employee.getSalary());
        employeeUpdate.setVat(employee.getSalary() * Constants.vat);
        employeeUpdate.setUpdatedDate(now);
        return employeeRepository.save(employeeUpdate);
    }

    public void deActivateEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    public void activateEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setActive(true);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}