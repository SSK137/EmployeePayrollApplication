package com.example.employeepayrollapplication.Repository;

import com.example.employeepayrollapplication.Model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeeDetails,Long> {
}