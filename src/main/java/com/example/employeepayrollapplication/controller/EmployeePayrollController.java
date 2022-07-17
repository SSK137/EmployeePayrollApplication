package com.example.employeepayrollapplication.controller;

import com.example.employeepayrollapplication.model.EmployeeDetails;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.dto.ResponceDTO;
import com.example.employeepayrollapplication.services.EmployeePayrollServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayrollController {
    @Autowired
    EmployeePayrollServicesInterface employeePayrollServicesInterface;
    @GetMapping("/hello")
    public String getMessage(){
        return "Hello World !!!!";
    }
    //PostMapping Employee Details
//    @PostMapping("/postMap")
//    public EmployeeDetails postDetail(@RequestBody EmployeeDetails employeeDetails){
//        EmployeeDetails employeeDetails1=employeePayrollServices.postDetails(employeeDetails);
//        return employeeDetails1;
//    }
//
//    //GetMapping Employee Details
//    @GetMapping("/getMap/{id}")
//    public Optional<EmployeeDetails> getDetail(@PathVariable Long id){
//        Optional<EmployeeDetails> employeeDetails=employeePayrollServices.getDetails(id);
//        return employeeDetails;
//    }
//
//    //PutMapping Employee Details
//    @PutMapping("/putMap/{id}")
//    public EmployeeDetails putDetails(@RequestBody EmployeeDetails employeeDetails,@PathVariable Long id){
//        EmployeeDetails employeeDetails1=employeePayrollServices.putDetails(employeeDetails,id);
//        return employeeDetails1;
//    }
//
//    //Delete Employee Details
//    @DeleteMapping("/deleteMap/{id}")
//    public String  deleteDetails(@PathVariable Long id){
//        employeePayrollServices.deleteDetails(id);
//        return "Record Deleted";
//    }

    //************************** DTO *******************************//

    //GetMapping Employee Details
    @GetMapping("/getall")
    public ResponseEntity<ResponceDTO> getalldetails(){
        List<EmployeeDetails> employeeDetails=employeePayrollServicesInterface.getAllDetails();
        ResponceDTO responceDTO=new ResponceDTO("All Employee Details",employeeDetails);
        return new ResponseEntity<ResponceDTO>(responceDTO,HttpStatus.OK);
    }
    @GetMapping("/getMap/{id}")
    public ResponseEntity<ResponceDTO> getEmployeePayrollData(@PathVariable int id) {
        ResponceDTO respDTO= new ResponceDTO("Employee Details :", employeePayrollServicesInterface.getEmployeeById(id));
        return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
    }
    @PostMapping("/postMap")
    public ResponseEntity<ResponceDTO> addEmployeePayrollData(@Valid @RequestBody EmployeeDTO empPayrollDTO) {
        EmployeeDetails  empData= employeePayrollServicesInterface.createEmployeePayrollData(empPayrollDTO);
        ResponceDTO respDTO= new ResponceDTO("Created New Employee Details Successfully", empData);
        return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
    }
    @PutMapping("/putMap/{id}")
    public ResponseEntity<ResponceDTO> updateEmployeePayrollData(@PathVariable int id,@RequestBody EmployeeDTO empPayrollDTO) {
        ResponceDTO respDTO= new ResponceDTO("Updated Employee Details Successfully", employeePayrollServicesInterface.editEmployee(id,empPayrollDTO));
        return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
    }
    @DeleteMapping("/deleteMap/{id}")
    public ResponseEntity<ResponceDTO> deleteEmployeePayrollData(@PathVariable int id) {
        ResponceDTO respDTO= new ResponceDTO("Deleted Employee Details Successfully", employeePayrollServicesInterface.deleteEmployee(id));
        return new ResponseEntity<ResponceDTO> (respDTO, HttpStatus.OK);
    }
}
