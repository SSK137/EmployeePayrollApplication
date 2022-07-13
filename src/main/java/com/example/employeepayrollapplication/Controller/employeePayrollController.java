package com.example.employeepayrollapplication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class employeePayrollController {
    @GetMapping("/hello")
    public String getMessage(){
        return "Hello World !!!!";
    }
}
