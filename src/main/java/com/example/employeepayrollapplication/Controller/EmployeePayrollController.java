package com.example.employeepayrollapplication.Controller;

import com.example.employeepayrollapplication.Model.EmployeeDetails;
import com.example.employeepayrollapplication.Repository.EmployeePayrollRepository;
import com.example.employeepayrollapplication.Services.EmployeePayrollServices;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.dto.ResponceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeePayrollController {
    @Autowired
    EmployeePayrollServices employeePayrollServices;
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;
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
    public String  deleteDetails(@PathVariable Long id){
        employeePayrollServices.deleteDetails(id);
        return "Record Deleted";
    }

    //************************** DTO *******************************//

    //GetMapping Employee Details
    @GetMapping("/getdto/{id}")
    public ResponseEntity<ResponceDTO> getdatabydto(@PathVariable Long id){
        ResponceDTO responceDTO=new ResponceDTO("Employee Details : ",employeePayrollRepository.findById(id));
        return new ResponseEntity<ResponceDTO>(responceDTO,HttpStatus.OK);
    }
    //PostMapping Employee Details
    @PostMapping("/postdto")
    public ResponseEntity<ResponceDTO> postdatabydto(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1=new EmployeeDTO(1,employeeDTO);
        ResponceDTO responceDTO=new ResponceDTO("Created Employee Data",employeeDTO1);
        return  new ResponseEntity<ResponceDTO>(responceDTO,HttpStatus.OK);
    }
    //PutMapping Employee Details
    @PutMapping("putdto")
    public ResponseEntity<ResponceDTO> pustbydto(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1=new EmployeeDTO(1,employeeDTO);
        ResponceDTO responceDTO=new ResponceDTO("Updated Details",employeeDTO1);
        return new ResponseEntity<ResponceDTO>(responceDTO,HttpStatus.OK);
    }
    //Delete Employee Details
    @DeleteMapping("/deletedto/{id}")
    public ResponseEntity<ResponceDTO> deletebydto(@PathVariable int id){
        ResponceDTO responceDTO=new ResponceDTO("Details Deleted",id);
        return new ResponseEntity<ResponceDTO>(responceDTO,HttpStatus.OK);
    }
}
