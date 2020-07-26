package fazluljony;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//add email field for emailAddress and team
	private String emailAddress;
	private String  team;
	
	
	public CricketCoach() {
		
		System.out.println("You have entered Cricket coach consttructor");
	}

	//public CricketCoach(FortuneService fortuneService) {
		
		//this.fortuneService = fortuneService;
	//}

	//setter method for fortune service
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("You have entered Cricketcoach setter method- setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	//generate setter method for emailAddress and team
	
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Prcatice fast bowling for today";
	}
	
	//generate setter and getter method for emailAddress
	public String getEmailAddress() {
		
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("You have entered Cricketcoach setter method- Email Address");
		this.emailAddress = emailAddress;
	}
	
	//generate setter and getter method for  team

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("You have entered Cricketcoach setter method- Email Address");
		this.team = team;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune() ;
	}

}
