package com.example.hr_manage.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String employeeId;

    private String employeeName;

    private LocalDate birthday;

    private String phoneNumber;

    private String email;

    public Object getPhoneNumber;
    

    public void setPhoneNumber(Object phoneNumber) {
    }

    public Object getEmployeeName() {
    }
}
