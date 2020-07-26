package fazluljony.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addSillyMember()
	{
		System.out.println(getClass()+ ":Doing stuff: Adding A membership Account");
	  
		return true;
	}


	public void goToSleep()
	{
		System.out.println(getClass() + ":I'm going to sleep now...");
	}
	
}
