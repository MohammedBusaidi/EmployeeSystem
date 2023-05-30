package com.EmployeeSystem.EmployeeSystem.Employee;

import com.EmployeeSystem.EmployeeSystem.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeId;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "passport_Number")
    private String passportNumber;
    @Column(name = "passport_Issue_Date")
    private String passportIssueDate;
    @Column(name = "passport_Expiry_Date")
    private String passportExpiryDate;
    @Column(name = "visa_Number")
    private String visaNumber;
    @Column(name = "visa_Issue_Date")
    private String visaIssueDate;
    @Column(name = "visa_Expiry_Date")
    private String visaExpiryDate;
    @Column(name = "date_of_Entry")
    private String dateOfEntryCountry;
    @Column(name = "airport_Of_Departure")
    private String airportOfDeparture;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "sr_number")
    private String srNumber;
    @Column(name = "place_of_work")
    private String placeOfWork;
    @Column(name = "start_of_contract")
    private Date startOfContract;
    @Column(name = "end_of_contract")
    private Date endOfContract;
    @Column(name = "salary")
    private Float salary;
    @Column(name = "vat")
    private Double vat = salary * 0.05;


}
