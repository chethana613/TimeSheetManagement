package com.employee.timesheet.dto;

import lombok.Data;

@Data
public class TimesheetRequestDto {

	private Long employeeId;
	private Integer hours;
}
