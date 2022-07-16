package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.exceptionhandler.EmployeePayrollException;
import com.example.employeepayrollapplication.model.EmployeeDetails;
import com.example.employeepayrollapplication.repository.EmployeePayrollRepository;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    List<EmployeeDetails> empDataList = new ArrayList<>();
    public EmployeeDetails getEmployeeById(int id) {
        return empDataList.stream()
                .filter(empData -> empData.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found!"));
    }
    public List<EmployeeDetails> getAllDetails(){
        return empDataList;
    }
    public EmployeeDetails createEmployeePayrollData(EmployeeDTO employeeDTO) {
        EmployeeDetails empData = new EmployeeDetails(employeeDTO);
        //empDataList.add(empData);
        employeePayrollRepository.save(empData);
        return empData;
    }
    public EmployeeDetails editEmployee(int id,EmployeeDTO employeePayrollDTO) {
        EmployeeDetails empData=this.getEmployeeById(id);
        empData.setName(employeePayrollDTO.name);
        empData.setDepartment(employeePayrollDTO.department);
        empData.setGender(employeePayrollDTO.gender);
        empData.setSalary(employeePayrollDTO.salary);
        empDataList.set(id-1,empData);
        return empData;
    }
    public void deleteEmployee(int id)
    {
        empDataList.remove(id-1);
    }
}