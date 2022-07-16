package com.example.employeepayrollapplication.model;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public @Data class EmployeeDetails {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue
    int id;
    @Column(name = "name")
    private String name;
    private Long salary;
    private String gender;
    private String profilePic;
    private String note;
    private LocalDate startDate;
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "emp_id"))
    @ElementCollection
    public List<String> department;

    public EmployeeDetails(EmployeeDTO employeePayrollDTO) {
        this.id=id;
        this.name= employeePayrollDTO.name;
        this.department=employeePayrollDTO.department;
        this.gender=employeePayrollDTO.gender;
        this.salary=employeePayrollDTO.salary;
        this.startDate=employeePayrollDTO.startDate;
        this.profilePic=employeePayrollDTO.profilePic;
        this.note=employeePayrollDTO.note;
    }

}