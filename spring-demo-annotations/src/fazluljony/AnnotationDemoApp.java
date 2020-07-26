package fazluljony;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring configure file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		
		//default bean id which written by small letter first at class 
		//Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		//test default with component which show error
		//Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		
		
		
		//call a method of bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		
		//close the context
		context.close();
	}

}
