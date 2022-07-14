package com.example.employeepayrollapplication.Controller;

import com.example.employeepayrollapplication.Model.EmployeeDetails;
import com.example.employeepayrollapplication.Services.EmployeePayrollServices;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.dto.ResponceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeePayrollController {
    @Autowired
    EmployeePayrollServices employeePayrollServices;
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
    @GetMapping("/getMap/{empId}")
    public ResponseEntity<ResponceDTO> getEmployeePayrollData(@PathVariable int empId) {
        EmployeeDetails employeeDetails= employeePayrollServices.getEmployeeById(empId);
        ResponceDTO respDTO= new ResponceDTO("Employee Details :", employeeDetails);
        return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
    }
    @PostMapping("/postMap")
    public ResponseEntity<ResponceDTO> addEmployeePayrollData(@RequestBody EmployeeDTO empPayrollDTO) {
        EmployeeDetails  empData= employeePayrollServices.createEmployeePayrollData(empPayrollDTO);
        ResponceDTO respDTO= new ResponceDTO("Created New Employee Details Successfully", empData);
        return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
    }
    @PutMapping("/putMap/{id}")
    public ResponseEntity<ResponceDTO> updateEmployeePayrollData(@PathVariable("id")int id,@RequestBody EmployeeDTO empPayrollDTO) {
        EmployeeDetails empData= employeePayrollServices.editEmployee(id,empPayrollDTO);
        ResponceDTO respDTO= new ResponceDTO("Updated Employee Details Successfully", empData);
        return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
    }
    @DeleteMapping("/deleteMap/{empId}")
    public ResponseEntity<ResponceDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollServices.deleteEmployee(empId);
        ResponceDTO respDTO= new ResponceDTO("Deleted Employee Details Successfully", "Deleted id: "+empId);
        return new ResponseEntity<ResponceDTO> (respDTO, HttpStatus.OK);
    }
}
