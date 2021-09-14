package com.hsbc.employeepayroll.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.employeepayroll.dao.EmployeeDao;
import com.hsbc.employeepayroll.entity.Employee;
import com.hsbc.employeepayroll.exception.EmployeeNotFoundException;

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

	@Override
	public void deleteEmployeeById(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

}
