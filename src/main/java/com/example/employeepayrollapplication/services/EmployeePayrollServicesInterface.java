package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.model.EmployeeDetails;

import java.util.List;
import java.util.Optional;

public interface EmployeePayrollServicesInterface {
    Optional<EmployeeDetails> getEmployeeById(int id);
    List<EmployeeDetails> getAllDetails();
    EmployeeDetails createEmployeePayrollData(EmployeeDTO employeeDTO);
    EmployeeDetails editEmployee(int id,EmployeeDTO employeePayrollDTO);
    String deleteEmployee(int id);
}
