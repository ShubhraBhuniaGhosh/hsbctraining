package com.hsbc.employeepayroll.view;

import java.util.List;

import com.hsbc.employeepayroll.entity.Employee;

public interface View {

	public int welcome();
	public void displayAllEmployees(List<Employee> employees);
	public Employee acceptEmployee();
	void cleanUp();
}
