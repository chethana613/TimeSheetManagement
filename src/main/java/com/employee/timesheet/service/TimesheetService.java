package com.employee.timesheet.service;

import com.employee.dto.EmployeeResponse;
import com.employee.timesheet.dto.ResponseDto;
import com.employee.timesheet.dto.TimesheetRequestDto;
import com.employee.timesheet.entity.Employee;
import com.employee.timesheet.exception.EmployeeNotFoundException;

public interface TimesheetService {

	void addEmployeeEntry(EmployeeResponse employeeResponse);
	
	Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException;
	 ResponseDto saveTimeSheet(TimesheetRequestDto timesheetRequestDto) throws EmployeeNotFoundException;


}
