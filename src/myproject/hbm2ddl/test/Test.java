package myproject.hbm2ddl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myproject.hbm2ddl.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			Configuration config = new Configuration();
			config.configure("/myproject/hbm2ddl/resources/hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee emp = new Employee();
			emp.setEno(101);
			emp.setEname("Tofique");
			emp.setEsal(5440);
			emp.setEaddr("Indore");
			session.save(emp);
			tx.commit();
			System.out.println("Emp Insertion Successfully");
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
