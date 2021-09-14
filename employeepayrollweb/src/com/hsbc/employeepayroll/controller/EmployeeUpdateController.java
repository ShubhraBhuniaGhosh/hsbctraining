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
import com.hsbc.employeepayroll.entity.Manager;
import com.hsbc.employeepayroll.exception.EmployeeNotFoundException;
import com.hsbc.employeepayroll.factory.EmployeeDaoFactory;

@WebServlet("/updateemployee")
public class EmployeeUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("In delete Controller");
		EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
		
		try
		{
			Employee foundEmployee = employeeDao.findEmployeeById(id);
			
			//Fetch all Employees from DaoImpl 
			//List<Employee> allEmployees =  employeeDao.findAllEmployees();
			
			//setAttribute("key","value")
			//req.setAttribute("employees", allEmployees);//passing data to view using request Object
			req.setAttribute("employee", foundEmployee);
			RequestDispatcher dispatcher = req.getRequestDispatcher("editemployee.jsp");//This view we want to show
			dispatcher.forward(req, resp);
		}
		catch (EmployeeNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Here");
		//1 Fetching user request ,converting request parameters to Java types
		int id = Integer.parseInt(req.getParameter("id"));
		//int id = Integer.parseInt(req.getParameter("id"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		//2 Creating required Java Object
		Employee e = new Manager(id, "", salary, null, 0);
		
		//3. Delegating to appropriate Dao class
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		
		//4.Fetch result 
		boolean result = dao.updateEmployee(e);
		
		//5 Based on result decide what view to be shown to end user
		if(result)
		{
			//This continues with existing reqeust
				//-Attributes and HTTP method
			//RequestDispatcher dispatcher = req.getRequestDispatcher("employee");//This view we want to show
			//dispatcher.forward(req, resp);
			
			//This generates new Request
			resp.sendRedirect("employee");
		}
		else
		{
			
		}
	
		
		
	}
}

