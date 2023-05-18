package com.EmployeeSystem.EmployeeSystem.Employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

/*
* Dont return Employee entity directly from controller
* use response object, simnilarly use request object to take data from user
* instead of taking employee entity as input
* */
@RequestMapping("api/v1/employees") //api/v1 needed?
@AllArgsConstructor //What is the need for this?
public class EmployeeController {
    EmployeeService employeeService; //If this is not autowired than how it is initialized?

    @GetMapping() //add explicit mapping for this
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")  //get BY Id is a better option, user can not understand path var
    public Employee getById(@PathVariable("id") UUID employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping()//add explicit mapping for this
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping() //add explicit mapping for this
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }
    @DeleteMapping("{id}") //delete BY Id is a better option, user can not understand path var
    //Dont delete data instead make it isActive false
    public String deleteEmployee(@PathVariable("id") UUID employeeId) {
        return employeeService.deleteById(employeeId);
    }




}