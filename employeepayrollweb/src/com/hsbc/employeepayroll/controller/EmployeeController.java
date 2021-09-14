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
import com.hsbc.employeepayroll.factory.EmployeeDaoFactory;
import com.hsbc.employeepayroll.factory.EmployeeViewFactory;
import com.hsbc.employeepayroll.view.View;

@WebServlet("/employee")//URL pattern
public class EmployeeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//A Controller
		//1. Accept user's request & fetch request data
				//- validate it (username is MUST) 
		//2. Based on the request indentify appropriate class which can handle this request
		//3. Calling appropritate business method
		//4. Receive result from business method
		//5. Identify appropriate view and send data to that view
		
		//Fetch Object of respective DaoImpl from Factory
		EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
		
		//Fetch all Employees from DaoImpl 
		List<Employee> allEmployees =  employeeDao.findAllEmployees();
		
		//setAttribute("key","value")
		req.setAttribute("employees", allEmployees);//passing data to view using request Object
		RequestDispatcher dispatcher = req.getRequestDispatcher("employees.jsp");//This view we want to show
		dispatcher.forward(req, resp);//passing control to 
		
		
		//Print these employees on Console using Appropriate View class
		
		//1 Indentify View and get the Object
		//View view = EmployeeViewFactory.getEmployeeView();
		
		//call do display all method
		//pass appropriate data to the view
		//view.displayAllEmployees(allEmployees);
		
		
		
		
		
		
		
	}
}
