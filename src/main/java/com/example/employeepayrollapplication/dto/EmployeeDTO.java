package com.example.employeepayrollapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    public String name;
    public String gender;
    public String department;
    public long salary;
}
