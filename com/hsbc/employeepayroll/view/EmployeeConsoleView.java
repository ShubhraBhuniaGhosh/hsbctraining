package com.hsbc.employeepayroll.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hsbc.employeepayroll.entity.Employee;
import com.hsbc.employeepayroll.entity.Manager;
import com.hsbc.employeepayroll.validator.NotNullValidator;

public class EmployeeConsoleView implements View {
	
	private Scanner sc;
	
	public EmployeeConsoleView() 
	{
		this.sc = new Scanner(System.in);
	}

	@Override
	public void displayAllEmployees(List<Employee> employees) {

		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Id \t Name \t Salary \t Date Of Joining");
		System.out.println("-----------------------------------------------------------------------");

		for (Employee employee : employees) {
			System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getSalary()+"\t\t"+ DateFormat.getDateInstance(DateFormat.MEDIUM).format(employee.getDateOfJoining()));
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
	}

	@Override
	public Employee acceptEmployee()
	{
		NotNullValidator notNullValidator = new NotNullValidator();
		Employee newEmployee = null;
		try
		{
			System.out.println("Enter Employee Id");
			int id = sc.nextInt();
			System.out.println("Enter Name");
			String name = sc.next();
			if(!notNullValidator.accept(name))
				System.err.println("Name is MUST");
			System.out.println("Enter Salary");
			int salary = sc.nextInt();
			System.out.println("Enter Number of Projects");
			int numberOfProjects = sc.nextInt();
			System.out.println("Enter Date of Joining (dd/MM/yyyy)");
			String dateofJoiningStr = sc.next();
			System.out.println();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateOfJoining = dateFormat.parse(dateofJoiningStr);
			newEmployee = new Manager(id, name, salary, dateOfJoining, numberOfProjects);
			return newEmployee;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int welcome()
	{
		int option = 1;
		try
		{
			System.out.println("Welcome to Payroll System of HSBC");
			System.out.println("1. To Register New Employee");
			System.out.println("2. To View All Employees");
			System.out.println("-1. To Exit");
			System.out.println("Enter your choice");
			option = sc.nextInt();
			return option;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public void cleanUp()
	{
		sc.close();
	}
}
