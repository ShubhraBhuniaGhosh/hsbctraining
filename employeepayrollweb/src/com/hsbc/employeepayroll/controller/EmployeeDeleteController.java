package com.hsbc.employeepayroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.employeepayroll.dao.EmployeeDao;
import com.hsbc.employeepayroll.entity.Employee;
import com.hsbc.employeepayroll.exception.EmployeeNotFoundException;
import com.hsbc.employeepayroll.factory.EmployeeDaoFactory;

@WebServlet("/deleteemployee")
public class EmployeeDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("In delete Controller");
		EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
		
		try
		{
			employeeDao.deleteEmployeeById(id);
			
			//Fetch all Employees from DaoImpl 
			//List<Employee> allEmployees =  employeeDao.findAllEmployees();
			
			//setAttribute("key","value")
			//req.setAttribute("employees", allEmployees);//passing data to view using request Object
			RequestDispatcher dispatcher = req.getRequestDispatcher("employee");//This view we want to show
			dispatcher.forward(req, resp);
		}
		catch (EmployeeNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
}
