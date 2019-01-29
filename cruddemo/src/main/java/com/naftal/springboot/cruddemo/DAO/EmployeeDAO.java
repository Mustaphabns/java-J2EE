package com.naftal.springboot.cruddemo.DAO;

import java.util.List;

import com.naftal.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
public List<Employee> findAll();
public Employee findById(int id);
public void save(Employee theEmployee);
public void deleteById(int id);
	
}
