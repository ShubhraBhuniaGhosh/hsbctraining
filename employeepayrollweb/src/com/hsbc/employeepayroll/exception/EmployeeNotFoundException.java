package com.hsbc.employeepayroll.exception;

public class EmployeeNotFoundException extends Exception {

	private int id;
	
	
	public EmployeeNotFoundException(int id) {
		this.id = id;
	}
	
	public String toString()
	{
		return "Employee With Id "  + this.id + " Not Found";
	}

}
