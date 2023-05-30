package com.EmployeeSystem.EmployeeSystem.BaseEntity;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    private Date createdDate;
    private boolean isActive;
    private Date updatedDate;
}
