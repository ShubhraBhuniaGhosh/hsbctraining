package com.hsbc.employeepayroll.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.employeepayroll.dao.EmployeeDao;
import com.hsbc.employeepayroll.entity.Employee;
import com.hsbc.employeepayroll.entity.Manager;
import com.hsbc.employeepayroll.exception.EmployeeNotFoundException;

public class EmployeeJdbcDaoImpl implements EmployeeDao{

	private static final String UPDATE_EMPLOYEE_BY_ID_SQL = "UPDATE employee SET salary = ? WHERE id = ?";
	/**
	 * All SQL queries
	 */
	private static final String SELECT_EMPLOYEES_SQL = "SELECT * FROM employee";
	private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE id = ?";
	private static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";


	/**
	 * Database credentials
	 */
	private final String USER_NAME = "root";
	private final String PASSWORD = "root";	
	private final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/employees";


	private Connection con;

	public EmployeeJdbcDaoImpl() {

		try
		{
			Class.forName(DRIVER_CLASS_NAME);
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void addEmployee(Employee newEmployee) {

	}

	@Override
	public List<Employee> findAllEmployees() {

		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try
		{
			stmt = con.prepareStatement(SELECT_EMPLOYEES_SQL);
			resultSet = stmt.executeQuery();

			while(resultSet.next())
			{
				Employee e = new Manager();

				//Fetching value for id column from DB and putting it in employee Object
				e.setId(resultSet.getInt(1));		

				//Fetching value for name column from DB and putting it in employee Object
				e.setName(resultSet.getString(2));

				//Fetching value for salary column from DB and putting it in employee Object
				e.setSalary(resultSet.getInt(3));

				//Adding employee Object to List Object
				employees.add(e);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		//In production finally block is MUST to release the resources
		finally
		{
			try
			{
				if(resultSet!=null)
				{
					resultSet.close();
				}

				if(stmt != null)
				{
					stmt.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		//Returning list with All Employees
		return employees;
	}

	@Override
	public void deleteEmployeeById(int id) throws EmployeeNotFoundException {
		
		int numberOfRowsUpdated = 0;
		PreparedStatement stmt = null;

		try
		{
			stmt = con.prepareStatement(DELETE_EMPLOYEE_BY_ID);
			stmt.setInt(1, id);
			numberOfRowsUpdated = stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//In production finally block is MUST to release the resources
		finally
		{
			try
			{
				if(stmt != null)
				{
					stmt.close();
				}
				
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			if(numberOfRowsUpdated==0)
				throw new EmployeeNotFoundException(id);
		}

		
	}

	@Override
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException
	{
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		Employee e = null;
		
		try
		{
			stmt = con.prepareStatement(FIND_EMPLOYEE_BY_ID);
			stmt.setInt(1, id);
			resultSet = stmt.executeQuery();

			if(resultSet.next())
			{	e = new Manager();//else it will create a manager with all values 0 and null and return that
				//Fetching value for id column from DB and putting it in employee Object
				e.setId(resultSet.getInt(1));		

				//Fetching value for name column from DB and putting it in employee Object
				e.setName(resultSet.getString(2));

				//Fetching value for salary column from DB and putting it in employee Object
				e.setSalary(resultSet.getInt(3));
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}

		//In production finally block is MUST to release the resources
		finally
		{
			try
			{
				if(resultSet!=null)
				{
					resultSet.close();
				}

				if(stmt != null)
				{
					stmt.close();
				}
			}
			catch (SQLException ex) 
			{
				ex.printStackTrace();
			}
		}

		//Returning list with All Employees
		return e;

	}

	@Override
	public boolean updateEmployee(Employee e) {
		
		int numberOfRowsUpdate  = 0;
		PreparedStatement stmt = null;
		
		try
		{
			stmt = con.prepareStatement(UPDATE_EMPLOYEE_BY_ID_SQL);
			stmt.setInt(1, e.getSalary());
			stmt.setInt(2, e.getId());
			
			numberOfRowsUpdate = stmt.executeUpdate();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return (numberOfRowsUpdate==1);
	}
}

