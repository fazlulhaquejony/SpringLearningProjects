package fazluljony;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring configure file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");
		//relative bean from the spring container
		
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class );		
		
		
		//call method on the bean
		
	   System.out.println(theCoach.getDailyFortune());
	   
	   System.out.println(theCoach.getDailyWorkout());
	   
	   //call new method for get literal value
	   
	   System.out.println(theCoach.getEmailAddress());
	   System.out.println(theCoach.getTeam());
	   
	   
		
		//close the context
		context.close();

	}

}
