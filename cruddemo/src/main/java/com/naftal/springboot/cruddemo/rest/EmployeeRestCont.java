package com.naftal.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naftal.springboot.cruddemo.DAO.EmployeeDAO;
import com.naftal.springboot.cruddemo.DAO.EmployeeImpDAO;
import com.naftal.springboot.cruddemo.entity.Employee;
import com.naftal.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestCont {

	private EmployeeService enmployeeservice;
	
	@Autowired
	public EmployeeRestCont(EmployeeService theEmployeeService) {
		enmployeeservice=theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return enmployeeservice.findAll();
	}

	
	@GetMapping("/employees/{IdEmployee}")
	public Employee findById(@PathVariable int IdEmployee){
		return enmployeeservice.findById(IdEmployee);
	}
    
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee){
		employee.setId(0);
		enmployeeservice.save(employee);
	return employee;
	}
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee){
		enmployeeservice.save(employee);
	return employee;
	}
	@DeleteMapping("/employees/{IdEmployee}")
	public String delete(@PathVariable int IdEmployee){
		enmployeeservice.deleteById(IdEmployee);
	return "the employe deleted is : " + IdEmployee;
	}
}











