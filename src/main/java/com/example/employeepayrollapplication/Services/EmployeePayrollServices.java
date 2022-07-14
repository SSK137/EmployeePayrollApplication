package com.example.employeepayrollapplication.Services;

import com.example.employeepayrollapplication.Model.EmployeeDetails;
import com.example.employeepayrollapplication.Repository.EmployeePayrollRepository;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollServices {
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    ArrayList<EmployeeDetails> EmployeeArrayList;

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
        return empDataList.get(id-1);
    }
    public EmployeeDetails createEmployeePayrollData(EmployeeDTO employeePayrollDTO) {
        EmployeeDetails empData = new EmployeeDetails(empDataList.size()+1,employeePayrollDTO);
        empDataList.add(empData);
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