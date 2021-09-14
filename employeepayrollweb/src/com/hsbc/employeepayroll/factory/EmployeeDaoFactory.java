package com.hsbc.employeepayroll.factory;

import com.hsbc.employeepayroll.dao.EmployeeDao;
import com.hsbc.employeepayroll.dao.impl.EmployeeJdbcDaoImpl;

abstract public class EmployeeDaoFactory {

	public static EmployeeDao getEmployeeDao()
	{
		EmployeeDao employeeDao = new EmployeeJdbcDaoImpl();
		return employeeDao;
	}
}
