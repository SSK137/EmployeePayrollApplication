package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.model.EmployeeDetails;
import com.example.employeepayrollapplication.repository.EmployeePayrollRepository;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollServices implements EmployeePayrollServicesInterface{
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

//    public EmployeeDetails postDetails(EmployeeDTO employeeDTO){
//        EmployeeDetails employeeDetails1=new EmployeeDetails(employeeDTO);
//        employeePayrollRepository.save(employeeDetails1);
//        return employeeDetails1;
//    }
//
//    //Display Perticular Employee Details
//    public Optional<EmployeeDetails> getDetails(Long id){
//        return employeePayrollRepository.findById(id);
//    }
//
//    //Edit or Update Employee Details
//    public EmployeeDetails putDetails(EmployeeDetails employeeDetails,Long id){
//        EmployeeDetails employeeDetails1=new EmployeeDetails(employeeDetails,id);
//        employeePayrollRepository.save(employeeDetails1);
//        return employeeDetails1;
//    }
//
//    //Delete Employee Details
//    public String  deleteDetails(Long id){
//        EmployeeDetails employeeDetails=new EmployeeDetails(id);
//        employeePayrollRepository.delete(employeeDetails);
//        return "EmployeeDetails Deleted SuccessFully  !!!!!";
//    }

    //****************************** Using DTO ****************************************
    //List<EmployeeDetails> empDataList = new ArrayList<>();
    public Optional<EmployeeDetails> getEmployeeById(int id) {
        return employeePayrollRepository.findById(id);
    }
    public List<EmployeeDetails> getAllDetails(){
        return employeePayrollRepository.findAll();
    }
    public EmployeeDetails createEmployeePayrollData(EmployeeDTO employeeDTO) {
        EmployeeDetails empData = new EmployeeDetails(employeeDTO);
        employeePayrollRepository.save(empData);
        return empData;
    }
    public EmployeeDetails editEmployee(int id,EmployeeDTO employeePayrollDTO) {
        EmployeeDetails employeeDetails=new EmployeeDetails(id,employeePayrollDTO);
        employeePayrollRepository.save(employeeDetails);
        return employeeDetails;
    }

    public String deleteEmployee(int id) {
        EmployeeDetails employeeDetails=new EmployeeDetails(id);
        employeePayrollRepository.delete(employeeDetails);
        return "Employee Details Deleted Successfully..!!";
    }
}