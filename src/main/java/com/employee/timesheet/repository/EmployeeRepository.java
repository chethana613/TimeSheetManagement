package com.employee.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.timesheet.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
