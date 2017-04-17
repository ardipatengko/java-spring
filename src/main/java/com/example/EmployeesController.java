package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {
	List<Employees> list = new ArrayList<Employees>();
	Employees e1 = new Employees("Ani", "Female");
	Employees e2 = new Employees("Budi", "Male");
	Employees e3 = new Employees("Cani", "Female");
	Employees e4 = new Employees("Dodi", "Male");
	
	public EmployeesController() {
		list.add(e1); list.add(e2); list.add(e3); list.add(e4);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	//@ResponseBody
	public List<Employees> getEmployees(@RequestParam String gender){
		return list.stream().filter(e -> e.gender.equals(gender)).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employees createdEmployee(@RequestBody(required = true) Employees e){
		return e;
	}
}
