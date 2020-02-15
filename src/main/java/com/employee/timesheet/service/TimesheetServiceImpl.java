package com.employee.timesheet.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeResponse;
import com.employee.timesheet.constants.ApplicationConstants;
import com.employee.timesheet.dto.ResponseDto;
import com.employee.timesheet.dto.TimesheetRequestDto;
import com.employee.timesheet.entity.Employee;
import com.employee.timesheet.entity.TimeSheet;
import com.employee.timesheet.exception.EmployeeNotFoundException;
import com.employee.timesheet.repository.EmployeeRepository;
import com.employee.timesheet.repository.TimeSheetManagement;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TimesheetServiceImpl implements TimesheetService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	TimeSheetManagement timeSheetManagement;
	
	public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException(ApplicationConstants.EMPLOYEE_NOT_FOUND);
		}
		return employee.get();
	}
	
	public void addEmployeeEntry(EmployeeResponse employeeResponse) {
		log.info("Entering into addEmployeeEntry of TimesheetServiceImpl");
		Employee employee= new Employee();
		BeanUtils.copyProperties(employeeResponse, employee);
		employeeRepository.save(employee);
		log.debug("AddEmployeeEntry saved successfully in TimesheetServiceImpl");
	}
	
	public ResponseDto saveTimeSheet(TimesheetRequestDto timesheetRequestDto) throws EmployeeNotFoundException {
		log.info("Entering into saveTimeSheet()");
		Optional<Employee> employee= employeeRepository.findById(timesheetRequestDto.getEmployeeId());
		if(!employee.isPresent()) {
			log.error("Exception occured in saveTimeSheet()");
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		TimeSheet timeSheet= new TimeSheet();
		timeSheet.setDate(Date.valueOf(LocalDate.now()));
		timeSheet.setEmployee(employee.get());
		timeSheet.setHours(timesheetRequestDto.getHours());
		timeSheet.setStatus("SUBMITTED");
		timeSheetManagement.save(timeSheet);
		
		return new ResponseDto();
	}
}
