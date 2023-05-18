package com.EmployeeSystem.EmployeeSystem.Employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    /*use small letters for column names
    * Created, Updated and isActive is missing*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, // Generation type sequence is better performance
            generator = "UUID" //ULID uses a timestamp and is performance wise better
    )
    private UUID employeeId;//ULID uses a timestamp and is performance wise better

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Passport_Number")
    private String passportNumber;

    @Column(name = "Passport_Issue_Date")
    private String passportIssueDate;

    @Column(name = "Passport_Expiry_Date")
    private String passportExpiryDate;

    @Column(name = "Visa_Number")
    private String visaNumber;

    @Column(name = "Visa_Issue_Date")
    private String visaIssueDate;

    @Column(name = "Visa_Expiry_Date")
    private String visaExpiryDate;

    @Column(name = "Date_of_Entry")
    private String DateOfEntryCountry; //camel case

    @Column(name = "Airport_Of_Departure")
    private String airportOfDeparture;

}
