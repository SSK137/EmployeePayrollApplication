package com.example.employeepayrollapplication.repository;

import com.example.employeepayrollapplication.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeeDetails,Long> {
}
