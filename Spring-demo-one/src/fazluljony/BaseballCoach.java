package fazluljony;

public class BaseballCoach implements Coach{
	
	//define a private field for dependency
	
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	
	public BaseballCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	
	
	public String getDailyWorkout()
	{
		return "spend 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//use my fortune service to get a fortune
		return fortuneService.getFortune();
	}

}
