package com.example.employeepayrollapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeDTO {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    String Name;
    Long Salary;

    public EmployeeDTO(int id, EmployeeDTO employeeDTO) {
        this.Name=employeeDTO.Name;
        this.Salary=employeeDTO.Salary;
        this.id=id;
    }

    public EmployeeDTO(int id) {
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getSalary() {
        return Salary;
    }

    public void setSalary(Long salary) {
        Salary = salary;
    }
}
