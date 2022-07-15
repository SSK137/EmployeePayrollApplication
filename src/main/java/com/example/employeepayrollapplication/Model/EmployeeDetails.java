package com.example.employeepayrollapplication.Model;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

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
    @ElementCollection
    List<String> department;
    String gender;
    LocalDate startDate;
    String note;
    String profilePic;

    public EmployeeDetails(int id, EmployeeDTO employeeDTO) {
        this.id=id;
        this.name= employeeDTO.name;
        this.department=employeeDTO.department;
        this.gender=employeeDTO.gender;
        this.salary=employeeDTO.salary;
        this.startDate=employeeDTO.startDate;
        this.profilePic=employeeDTO.profilePic;
        this.note=employeeDTO.note;
    }
}