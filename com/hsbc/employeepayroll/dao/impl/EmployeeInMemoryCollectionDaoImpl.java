package com.hsbc.employeepayroll.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.employeepayroll.dao.EmployeeDao;
import com.hsbc.employeepayroll.entity.Employee;

public class EmployeeInMemoryCollectionDaoImpl implements EmployeeDao{

	private List<Employee> employees;
	
	public EmployeeInMemoryCollectionDaoImpl() {
		this.employees = new ArrayList<>();
	}
	
	@Override
	public void addEmployee(Employee newEmployee) {
		this.employees.add(newEmployee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return this.employees;
	}

}
