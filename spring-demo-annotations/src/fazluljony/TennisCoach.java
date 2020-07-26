package fazluljony;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	

	//define FortuneService constructor
	
	public TennisCoach() {
		System.out.println(">>Inside the TennisCoach default  constractor");
	}
	
	//define init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println(">>TessinCoach : inside of domystartupStuff");
	}
	
	//define destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println(">>TessinCoach : inside of domycleanupStuff");
	}
	
	
	/*
	//Define any method
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">>Inside the FortuneService any Method");
		this.fortuneService = fortuneService;
	}
	*/
	
	
	/*
	//Define setter method
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">>Inside the FortuneService setter Method");
		this.fortuneService = fortuneService;
	}
	*/
	
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
	
		this.fortuneService = fortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		
		return "Tenis coach workout is working";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
