package com.employee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class ManageEmployee {

	public static SessionFactory factory;

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("Employee.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		  c.add(Restrictions.eq("name", "Rajesh"));
		  
		  List<Employee> l = c.list();
		  
		  
		  for(Employee emp:l) {
		  
		  System.out.println(emp);
		  
		  }
//		Employee employee1 = new Employee();
//		employee1.setName("Rajesh");
//		employee1.setSalary(30000);
//		session.save(employee1);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}

}
