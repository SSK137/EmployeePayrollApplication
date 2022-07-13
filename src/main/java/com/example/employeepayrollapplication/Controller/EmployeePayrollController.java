package com.example.employeepayrollapplication.Controller;

import com.example.employeepayrollapplication.Model.EmployeeDetails;
import com.example.employeepayrollapplication.Services.EmployeePayrollServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeePayrollController {
    @Autowired
    EmployeePayrollServices employeePayrollServices;
    @GetMapping("/hello")
    public String getMessage(){
        return "Hello World !!!!";
    }
    //PostMapping Employee Details
    @PostMapping("/postMap")
    public EmployeeDetails postDetail(@RequestBody EmployeeDetails employeeDetails){
        EmployeeDetails employeeDetails1=employeePayrollServices.postDetails(employeeDetails);
        return employeeDetails1;
    }

    //GetMapping Employee Details
    @GetMapping("/getMap/{id}")
    public Optional<EmployeeDetails> getDetail(@PathVariable Long id){
        Optional<EmployeeDetails> employeeDetails=employeePayrollServices.getDetails(id);
        return employeeDetails;
    }

    //PutMapping Employee Details
    @PutMapping("/putMap/{id}")
    public EmployeeDetails putDetails(@RequestBody EmployeeDetails employeeDetails,@PathVariable Long id){
        EmployeeDetails employeeDetails1=employeePayrollServices.putDetails(employeeDetails,id);
        return employeeDetails1;
    }

    //Delete Employee Details
    @DeleteMapping("/deleteMap/{id}")
    public EmployeeDetails deleteDetails(@PathVariable Long id){
        EmployeeDetails employeeDetails=employeePayrollServices.deleteDetails(id);
        return employeeDetails;
    }
}
