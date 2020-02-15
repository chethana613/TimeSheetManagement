package com.employee.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.timesheet.constants.ApplicationConstants;
import com.employee.timesheet.entity.Employee;
import com.employee.timesheet.exception.EmployeeNotFoundException;
import com.employee.timesheet.service.TimesheetService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/timesheets")
@RestController
@CrossOrigin
@Slf4j
public class TimesheetController {

	@Autowired
	TimesheetService timesheetService;

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) throws EmployeeNotFoundException {
		if (ObjectUtils.isEmpty(employeeId)) {
			log.info("Exception occurred in TimesheetController getEmployeeById method:"+ApplicationConstants.EMPLOYEE_NOT_FOUND);
			throw new EmployeeNotFoundException(ApplicationConstants.EMPLOYEE_NOT_FOUND);
		}
		log.info("Entering into TimesheetController getEmployeeById method: calling timeSheetService");
		return new ResponseEntity<>(timesheetService.getEmployeeById(employeeId), HttpStatus.OK);
	}

}
