package com.example.employeepayrollapplication.Repository;

import com.example.employeepayrollapplication.Model.employeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeePayrollRepository extends JpaRepository<employeeDetails,Long> {
}
