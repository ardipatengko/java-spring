package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {
	List<Employees> list = new ArrayList<Employees>();
	Employees e1 = new Employees(1, "Ani", "Female");
	Employees e2 = new Employees(2, "Budi", "Male");
	Employees e3 = new Employees(3, "Cani", "Female");
	Employees e4 = new Employees(4, "Dodi", "Male");
	
	public EmployeesController() {
		list.add(e1); list.add(e2); list.add(e3); list.add(e4);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	//@ResponseBody
	public List<Employees> getEmployeesAll(@RequestParam String gender){
		return list.stream().filter(e -> e.gender.equals(gender)).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/employeesAll", method = RequestMethod.GET)
	//@ResponseBody
	public List<Employees> getEmployees(){
		return list;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employees createdEmployee(@RequestBody(required = true) Employees e){
		return e;
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public Employees findEmployeeById(@PathVariable int id){
		if (list.stream().filter(e -> e.id == id).count() > 0){
			return list.stream().filter(e -> e.id == id).findFirst().get();
		}else{
			throw new EmployeeNotFoundException();
		}
	}
}
