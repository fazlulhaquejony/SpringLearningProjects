package fazluljony.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fazluljony.aop.dao.AccountDAO;
import fazluljony.aop.dao.MembershipDAO;

public class MainApp {
	
	public static void main(String[] args)
	{
		//read spring configure java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);;
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO themembershipAccount =context.getBean("membershipDAO",MembershipDAO.class);
		
		Account myAccount = new Account();
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
		//close the context
		context.close();
		
	}

}
