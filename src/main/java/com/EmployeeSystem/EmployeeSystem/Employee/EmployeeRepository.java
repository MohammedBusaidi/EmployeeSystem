package com.EmployeeSystem.EmployeeSystem.Employee;

import com.EmployeeSystem.EmployeeSystem.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
