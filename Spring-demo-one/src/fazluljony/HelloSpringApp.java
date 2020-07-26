package fazluljony;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load spring configuration file
		 ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve been from spring container
		     Coach theCoach = context.getBean("myCoach",Coach.class);
		//call method on the beans
		     System.out.println(theCoach.getDailyWorkout());
		     System.out.println(theCoach.getDailyFortune());
	
		context.close();

	}

}
