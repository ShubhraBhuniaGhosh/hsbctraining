package com.hsbc.employeepayroll.view.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.employeepayroll.entity.Employee;

@WebServlet("/employeeview")
public class EmployeeWebView extends HttpServlet{

	
	//Responsible showing list of Employees on Web page
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//mixing the roles - not recommended
		PrintWriter out = resp.getWriter();
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Salary</th>");
		out.println("</tr>");
		
		List<Employee> allEmployees = (List<Employee>) req.getAttribute("employees");
		
		for (Employee employee : allEmployees) 
		{	
			out.println("<tr>");
			out.println("<td>"+employee.getId()+" "+employee.getName()+" "+employee.getSalary()+"</td>");
			out.println("<tr>");
			
		}
		out.println("</table>");
		
		
		out.close();
	}
}
