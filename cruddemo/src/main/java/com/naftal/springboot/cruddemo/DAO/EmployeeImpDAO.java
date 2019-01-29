package com.naftal.springboot.cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naftal.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeImpDAO implements EmployeeDAO {

	private EntityManager entityManage;
	
	@Autowired
	public EmployeeImpDAO(EntityManager theEntityManager) {
		entityManage=theEntityManager;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		Session session = entityManage.unwrap(Session.class);
		
		Query<Employee> theQuery=session.createQuery("from Employee",Employee.class);
		
		List<Employee> theEmployee=theQuery.getResultList(); 
		
		return theEmployee;
	}
	@Override
	public Employee findById(int id) {
	Session session = entityManage.unwrap(Session.class);
		Employee thEmployee=session.get(Employee.class, id);
		return thEmployee;
	}
	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Session session = entityManage.unwrap(Session.class);
		session.saveOrUpdate(theEmployee);
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManage.unwrap(Session.class);
		Query thQuery=session.createQuery("delete Employee where id=:idEmployee");
        thQuery.setParameter("idEmployee",id );
        thQuery.executeUpdate();
	}

	
	
}


























