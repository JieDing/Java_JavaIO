package com.jieding.serialtest;

public class Manager extends Employee {
	
	private Employee secretary;
	
	public Employee getSecretary() {
		return secretary;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}

	public Manager(String name, int age, double salary) {
		super(name, age, salary);
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7169510824773865269L;
	
}
