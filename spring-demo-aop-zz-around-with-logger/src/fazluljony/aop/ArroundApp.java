 package fazluljony.aop;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import fazluljony.aop.service.TrafficFortuneService;

public class ArroundApp {
	

	public static void main(String[] args)
	{
		//read spring configure java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);;
		//get the bean from spring container
		TrafficFortuneService theFortuneService  = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain program AroundApp");
		
		
		System.out.println("Calling get fortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\n My Fortune is" + data);
		
		System.out.println("\n Finished");
		//close the context
		context.close();
		
	}

}
