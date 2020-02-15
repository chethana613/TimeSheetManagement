package com.employee.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private Long employeeId;
	private String employeeName;
	private String designation;

}
