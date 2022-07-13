package com.example.employeepayrollapplication.Repository;

import com.example.employeepayrollapplication.Model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeeDetails,Long> {
}
