package com.EmployeeSystem.EmployeeSystem.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "UUID"
    )
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private Date passportIssueDate;
    private Date passportExpiryDate;
    private String visaNumber;
    private Date visaIssueDate;
    private Date visaExpiryDate;

//    private LocalDateTime workStartDate;
//    private LocalDateTime workExpiryDate;
//    private String countryName;
//    private LocalDateTime entryDate;
//    private String airportOfArrival;
}
