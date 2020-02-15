package com.employee.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.timesheet.entity.TimeSheet;

public interface TimeSheetManagement extends JpaRepository<TimeSheet, Integer>{

}
