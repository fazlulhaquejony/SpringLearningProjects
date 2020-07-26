package fazluljony;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach()
	{
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hrad 5k trackcoach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "I love you fariha  " + fortuneService.getFortune();
	}
	
	//add a init method
	
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside the method doMyStartupStuff ");
	}
	
	//add destroy method
	public void doMycleanupStuffdestroy() {
		System.out.println("TrackCoach: inside the method doMycleanupStuffdestroy ");
	}

}