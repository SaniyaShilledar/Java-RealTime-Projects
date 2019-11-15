package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Transaction tx=null;
	Session ses=null;
	SessionFactory factory=null;
//		 
//	try {
//		
//		Configuration cfg=new Configuration();
//		cfg=cfg.configure("hibernate.cfg.xml");
//		factory=cfg.buildSessionFactory();
//		 ses = factory.openSession();
//		
		Product p=new Product();
		
		p.setPid(111);
	p.setProname("laptop");
	p.setPrice(25000);
//		
//		
//			 
// tx=ses.beginTransaction();
//		ses.save(p);
//		tx.commit();
//		System.out.println("Data inserted");
//		}
//		
//		catch(Exception e) {
//			tx.rollback();
//		}
//		
//		ses.close();
//		factory.close();
//		Session session;
	
		//Connection code
			// these 5 lines would remain same and is used for getting connection
	       Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); //connects to cfg
	       ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
	       SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());       		   
	          		 
	        ses =sessionFactory.openSession();	
	        System.out.println("Connected to Pf....");
		
		
		    ses.beginTransaction();
			ses.save(p);
			ses.getTransaction().commit();
			System.out.println("Insertion success...");
		
		
	

	}

}
