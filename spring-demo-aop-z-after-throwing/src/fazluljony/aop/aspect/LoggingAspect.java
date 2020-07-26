package fazluljony.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import fazluljony.aop.Account;

@Aspect
@Component
@Order(5)
public class LoggingAspect {
	
	@AfterThrowing(
			pointcut="execution(* fazluljony.aop.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint , Throwable theExc)
	{
		//print out which method we are advising on
String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n====>>> Executing @afterThrowing on method: " + method);
		//log the exception
		System.out.println("\n====>>> The exception is : " + theExc);
		
	}
	 
	
	
	
	
	
	
	
	
	//add a new advice for @AfterReturning 
	
	@AfterReturning(
			pointcut="execution(* fazluljony.aop.dao.AccountDAO.findAccounts(..))",
			returning ="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result)
	{
		//printout wchivh method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n====>>> Executing @afterReturning on method: " + method);
		
		//print the results of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		
		//tel's post-process the data.. tel's modify it :-)
		
		//convert the account name to upper case
		convertAccountNamesToUpperCase(result);
		System.out.println("\n====>>>> result is: " + result);
		
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
	
		for(Account tempAccount : result)
		{
			//get upper case version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			//update the name on the account
			tempAccount.setName(theUpperName);
		}
	}




	//this is where we add all of our related advices for logging
	
	//let's start with an @Before advice
	
	
	
	//@Before("execution(* add*(fazluljony.aop.Account))")
	@Before("fazluljony.aop.aspect.LuvAspectExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJointPoint)
	{
		System.out.println("\n ===>>> Executing @before advice on addAccount()");
	
		//display the method signature
		MethodSignature methodsig = (MethodSignature) theJointPoint.getSignature();
		
		//display method arguments
		System.out.println("Method : " + methodsig);
		
		//get args
		Object[] args = theJointPoint.getArgs();
	     
		for(Object tempArg :args)
		{
			System.out.println(tempArg);
		    
			if(tempArg instanceof Account)
			{
				Account theAccount = (Account) tempArg;
				System.out.println("account name:" + theAccount.getName());
				System.out.println("account name:" + theAccount.getLevel());
			}
		}
	
	
	
	
	}
	
	
	
	

}
