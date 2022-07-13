package com.example.employeepayrollapplication.Services;

import com.example.employeepayrollapplication.Model.EmployeeDetails;
import com.example.employeepayrollapplication.Repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeePayrollServices {
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    //Insert Details into DB Table
    public EmployeeDetails postDetails(EmployeeDetails employeeDetails){
        EmployeeDetails employeeDetails1=new EmployeeDetails(employeeDetails);
        employeePayrollRepository.save(employeeDetails1);
        return employeeDetails1;
    }

    //Display Perticular Employee Details
    public Optional<EmployeeDetails> getDetails(Long id){
        return employeePayrollRepository.findById(id);
    }

    //Edit or Update Employee Details
    public EmployeeDetails putDetails(EmployeeDetails employeeDetails,Long id){
        EmployeeDetails employeeDetails1=new EmployeeDetails(employeeDetails,id);
        employeePayrollRepository.save(employeeDetails1);
        return employeeDetails1;
    }

    //Delete Employee Details
    public EmployeeDetails deleteDetails(Long id){
        EmployeeDetails employeeDetails=new EmployeeDetails(id);
        employeePayrollRepository.delete(employeeDetails);
        return employeeDetails;
    }
}
