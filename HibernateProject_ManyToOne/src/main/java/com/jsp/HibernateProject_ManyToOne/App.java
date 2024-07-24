package com.jsp.HibernateProject_ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Company c = new Company();
    	c.setCompanyId(101);
    	c.setCompanyName("Wipro");
    	
    	Employee e1 = new Employee();
    	e1.setEmployeeId(7011);
    	e1.setEmployeeName("Tushar");
    	e1.setEmployeesalary(40000);
    	
    	Employee e2 = new Employee();
    	e2.setEmployeeId(7012);
    	e2.setEmployeeName("Vinayek");
    	e2.setEmployeesalary(40000);
    	
    	Employee e3 = new Employee();
    	e3.setEmployeeId(7013);
    	e3.setEmployeeName("Salak");
    	e3.setEmployeesalary(45000);
    	
    	
    e1.setCompany(c);
    e2.setCompany(c);
    e3.setCompany(c);
    	
    
    c.getEmployee().add(e1);
    c.getEmployee().add(e2);
    c.getEmployee().add(e3);
    
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session see = sf.openSession();
    	Transaction tr = see.beginTransaction();
    	
    	see.save(c);
    	see.save(e1);
    	see.save(e2);
    	see.save(e3);
    	
    	tr.commit();
    	see.close();
     	
    }
}
