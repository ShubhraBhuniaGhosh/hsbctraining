package com.hsbc.employeepayroll.factory;

import com.hsbc.employeepayroll.dao.EmployeeDao;
import com.hsbc.employeepayroll.dao.impl.EmployeeInMemoryCollectionDaoImpl;

abstract public class EmployeeDaoFactory {

	public static EmployeeDao getEmployeeDao()
	{
		EmployeeDao employeeDao = new EmployeeInMemoryCollectionDaoImpl();
		return employeeDao;
	}
}
