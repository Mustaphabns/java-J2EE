package com.naftal.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naftal.springboot.cruddemo.DAO.EmployeeDAO;
import com.naftal.springboot.cruddemo.entity.Employee;

@Service

public class EmployeeServiceImp implements EmployeeService {

	EmployeeDAO theEmployeeDAO;
	
	@Autowired
	public EmployeeServiceImp(EmployeeDAO employeeDAO) {
		theEmployeeDAO=employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return theEmployeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return theEmployeeDAO.findById(id);
		
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
     theEmployeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
 
		theEmployeeDAO.deleteById(id);
	}

}
