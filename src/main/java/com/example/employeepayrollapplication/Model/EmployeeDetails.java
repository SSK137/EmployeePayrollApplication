package com.example.employeepayrollapplication.Model;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public @ToString class EmployeeDetails {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue
    int id;
    @Column(name = "name")
    String name;
    Long salary;
    String gender;
    String profilePic;
    String note;
    LocalDate startDate;
    @CollectionTable(name = "employee_department", joinColumns =@JoinColumn(name = "id"))
    @ElementCollection
    public List<String> department;

    public EmployeeDetails(int id, EmployeeDTO employeePayrollDTO) {
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