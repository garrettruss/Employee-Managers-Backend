package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	

	// define field for entitymanager 
	private EntityManager entityManager;
	
	// set up constructor injection 
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query 
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		// execute the query 
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}

}
