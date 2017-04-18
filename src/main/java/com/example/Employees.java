package com.example;

public class Employees {
	int id;
	String name;
	String gender;
	
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Employees(){
		
	}
	
	public Employees(int id, String name, String gender) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

}
