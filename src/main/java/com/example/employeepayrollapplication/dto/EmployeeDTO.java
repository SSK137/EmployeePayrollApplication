package com.example.employeepayrollapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "Enter Valid Name..")
    public String name;
    @NotEmpty(message = "Employee Gender cannot Empty")
    public String gender;
    public String department;
    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

}
