package com.example.employeepayrollapplication.Model;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
    @Id
    @GeneratedValue
    int id;

    String name;
    Long salary;
    String department;
    String gender;

    public EmployeeDetails(int id, EmployeeDTO employeeDTO) {
        this.id=id;
        this.name= employeeDTO.name;
        this.department=employeeDTO.department;
        this.gender=employeeDTO.gender;
        this.salary=employeeDTO.salary;
    }
}