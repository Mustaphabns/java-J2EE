package com.naftal.springboot.cruddemo.service;

import java.util.List;

import com.naftal.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee theEmployee);
	public void deleteById(int id);

}
