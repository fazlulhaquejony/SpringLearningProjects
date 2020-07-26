package fazluljony.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fazluljony.hibernate.entity.Student;



public class CreateStudentDemo {
    
	public static void main(String[] args) {
		 System.out.println("program started");

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fazluljony.hibernate.entity.Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("Paul", "qwteroe", "paul@gtlai.com");
			Student tempStudent2 = new Student("jony", "fazlul", "jony@hm.com");
			Student tempStudent3 = new Student("Pria", "Doe", "ul@luode.com");
			Student tempStudent4 = new Student("takl", "eroe", "pl@luv.com");
			Student tempStudent5 = new Student("twqlol", "Drete", "ail@code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student1...");
			session.save(tempStudent1);
			System.out.println("Saving the student2...");
			session.save(tempStudent2);
			System.out.println("Saving the student3...");
			session.save(tempStudent3);
			System.out.println("Saving the student4...");
			session.save(tempStudent4);
			System.out.println("Saving the student5...");
			session.save(tempStudent5);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





