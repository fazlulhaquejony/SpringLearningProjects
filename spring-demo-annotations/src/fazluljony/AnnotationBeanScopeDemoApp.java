package fazluljony;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spring configure file

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		//check if same
		boolean result =(theCoach==alphaCoach);
		
		//print out the result
		System.out.println("\n pointing the same object:  "+ result);
		System.out.println("\n memory location for thecaoch:  "+ theCoach);
		System.out.println("\\\n memory location for alphacaoch:  \""+ alphaCoach);
		
		//close context
		context.close();

	}
	

}
