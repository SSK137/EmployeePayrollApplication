package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.model.EmployeeDetails;

import java.util.List;

public interface EmployeePayrollServicesInterface {
    EmployeeDetails getEmployeeById(int id);
    List<EmployeeDetails> getAllDetails();
    EmployeeDetails createEmployeePayrollData(EmployeeDTO employeeDTO);
    EmployeeDetails editEmployee(int id,EmployeeDTO employeePayrollDTO);
    void deleteEmployee(int id);
}
