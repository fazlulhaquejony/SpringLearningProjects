package fazluljony.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune()
	{
	//simulate a delay
	     try {
		    
	    	 TimeUnit.SECONDS.sleep(5);
	    	 
	       }
	       catch(InterruptedException e)
	     {
	   		e.printStackTrace();
	 	 }
     //return
	     return "Excetpt heavy traffic in this morning";
	}

	public String getFortune(boolean tripWire) {
		
		if(tripWire)
		{
			throw new RuntimeException("Major accident! High way is closed");
		}
		
		return getFortune() ;
	}
}
