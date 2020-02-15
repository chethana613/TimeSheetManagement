package com.employee.timesheet.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TimeSheet {
	@Id
	private Integer timeSheetId;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	private Date date;
	private String status;
	private Integer hours;
}
