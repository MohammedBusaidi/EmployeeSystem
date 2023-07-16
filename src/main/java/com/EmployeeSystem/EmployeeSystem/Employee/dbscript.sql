create database employees;

create user 'admin' @'localhost' identified by 'admin';
create user 'admin' @'127.0.0.1' identified by 'admin';

grant all privileges on employees.* to 'admin' @'localhost';
grant all privileges on employees.* to 'admin' @'127.0.0.1';

use employees;

CREATE TABLE `employees`.`user` (
    `employeeId` INT NOT NULL,
    `first_Name` VARCHAR(255) NOT NULL,
    `last_Name` VARCHAR(255) NOT NULL,
    `passport_Number` VARCHAR(255) NOT NULL,
    `passport_Issue_Date` DATE NOT NULL,
    `passport_Expiry_Date` DATE NOT NULL,
    `visa_Number` VARCHAR(255) NOT NULL,
    `visa_Issue_Date` DATE NOT NULL,
    `visa_Expiry_Date` DATE NOT NULL,
    `date_of_Entry` VARCHAR(255) NOT NULL,
    `airport_Of_Departure` VARCHAR(255) NOT NULL,
    `company_name` VARCHAR(255) NOT NULL,
    `sr_number` VARCHAR(255) NOT NULL,
    `place_of_work` VARCHAR(255) NOT NULL,
    `start_of_contract` DATE NOT NULL,
    `end_of_contract` DATE NOT NULL,
    `salary` FLOAT NOT NULL,
    `vat` FLOAT NOT NULL,
    PRIMARY KEY (`employeeId`)
) ENGINE = InnoDB;
