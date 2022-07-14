package com.example.employeepayrollapplication;

import com.example.employeepayrollapplication.Services.EmployeePayrollServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EmployeePayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollApplication.class, args);
        System.out.println("Welcome to Employee Payroll Application");
        System.out.println();
    }
}
