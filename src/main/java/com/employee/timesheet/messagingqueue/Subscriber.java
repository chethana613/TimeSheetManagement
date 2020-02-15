package com.employee.timesheet.messagingqueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeResponse;
import com.employee.timesheet.constants.ApplicationConstants;
import com.employee.timesheet.service.TimesheetService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Subscriber {

	@Autowired
	TimesheetService timesheetService;

	@JmsListener(destination = ApplicationConstants.EMPLOYEE_TOPIC, containerFactory = "topicListenerFactory")
	public void receiveTopicMessage(EmployeeResponse employeeResponse) {
		System.out.println("received <" + employeeResponse + ">");
		timesheetService.addEmployeeEntry(employeeResponse);
		log.info("received <" + employeeResponse + ">");
	}

}
