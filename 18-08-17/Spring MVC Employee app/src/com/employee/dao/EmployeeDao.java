package com.employee.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;


@Repository
public class EmployeeDao {

	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// saves employee details in datadase
	public void saveEmployee(Employee employee)
	{
		getTemplate().saveOrUpdate(employee);
	}
	
	// gets list of employees from database
	public List<Employee> getAllEmployees()
	{
		Session session = getFactory().openSession();
		SQLQuery query = session
				.createSQLQuery("select * from employee");
		query.addEntity(Employee.class);
		List<Employee> list = query.list();
		return list;
	}
	
	// method to delete employee from database
	public void delete(int id)
	{
		Employee employee = getTemplate().get(Employee.class, id);
		getTemplate().delete(employee);
	}
	
	// method to get employee details by id
	public Employee getById(int id)
	{
		return getTemplate().get(Employee.class, id);
	}
}
