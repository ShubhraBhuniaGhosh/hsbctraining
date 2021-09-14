package com.hsbc.employeepayroll.entity;

import java.util.Date;

abstract public class Employee {

	private int id;
	private String name;
	private int salary;
	private Date dateOfJoining;
	public Employee() {
		super();
	}
	public Employee(int id, String name, int salary, Date dateOfJoining) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining;
	}
	
	public abstract int calculateSalary();
	
	
}
