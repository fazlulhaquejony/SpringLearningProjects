 package fazluljony.aop;


import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import fazluljony.aop.service.TrafficFortuneService;


public class ArroundLoggerApp {
	private static Logger myLogger = Logger.getLogger(ArroundLoggerApp.class.getName());

	public static void main(String[] args)
	{
		//read spring configure java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);;
		//get the bean from spring container
		TrafficFortuneService theFortuneService  = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain program AroundLoggerApp");
		
		
		myLogger.info("Calling get fortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\n My Fortune is" + data);
		
		myLogger.info("\n Finished");
		//close the context
		context.close();
		
	}

}
