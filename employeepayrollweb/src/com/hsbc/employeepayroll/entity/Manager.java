package com.hsbc.employeepayroll.entity;

import java.util.Date;

public class Manager extends Employee{

	private int numberOfProjects;
		
	public Manager() {
		super();
	}

	public Manager(int id, String name, int salary, Date dateOfJoining,int numberOfProjects) {
		super(id, name, salary, dateOfJoining);
		this.numberOfProjects = numberOfProjects;
	}

	public int getNumberOfProjects() {
		return numberOfProjects;
	}

	public void setNumberOfProjects(int numberOfProjects) {
		this.numberOfProjects = numberOfProjects;
	}

	@Override
	public int calculateSalary() {
		// TODO Auto-generated method stub
		return 0;
	}
}
