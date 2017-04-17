package com.example;

public class Employees {
	String name;
	String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Employees(){
		
	}
	
	public Employees(String name, String gender) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gender = gender;
	}

}
