package fazluljony.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fazluljony.aop.dao.AccountDAO;
import fazluljony.aop.dao.MembershipDAO;

public class AfterReturningMainApp {
	
	public static void main(String[] args)
	{
		//read spring configure java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);;
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO themembershipAccount =context.getBean("membershipDAO",MembershipDAO.class);
		
		
		Account myAccount = new Account();
		myAccount.setName("jony");
		myAccount.setLevel("Platinum");
		
		//call the business method
		theAccountDAO.addAccount(myAccount, true );
		theAccountDAO.doWork();
		
		//call getter /setter
		theAccountDAO.setName("jony");
		theAccountDAO.setServiceCod("007");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCod();
		
		//do it again
		System.out.println("\n let's call it again\n");
		
		//call the method again
		themembershipAccount.addSillyMember();
		themembershipAccount.goToSleep();
		
		//call the method to find the accounts
		
		List<Account>theAccounts =theAccountDAO.findAccounts();
		
		System.out.println("\n\n Main Program : AfterReturning DemoApp");
		System.out.println("-----");
		
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		//close the context
		context.close();
		
	}

}
