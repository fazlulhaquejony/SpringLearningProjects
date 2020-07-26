package fazluljony.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import fazluljony.aop.Account;

@Aspect
@Component
@Order(5)
public class LoggingAspect {
	
	
	private Logger myLogger =Logger.getLogger(getClass().getName());
	
	
	@Around("execution(* fazluljony.aop.service.*.getFortune(..))")
	public Object arountGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
	
	//printout method we are advising on
		//print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n====>>> Executing @Around on method: " + method);
	
    //get begin time stamp
		
		long begin =System.currentTimeMillis();
		
	//now.let's execute the method
		
		Object result = theProceedingJoinPoint.proceed();
	
	//get end timestamp
		
		long end = System.currentTimeMillis();
		
	//compute duration and display
	long duration = end -begin;
		myLogger.info("\n======>Duration " + duration/1000.0 + "seconds");
		return result;
	}
	
	@After("execution(* fazluljony.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint)
	{
		//print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n====>>> Executing @afterThrowing on method: " + method);
	}
	
	
	@AfterThrowing(
			pointcut="execution(* fazluljony.aop.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint , Throwable theExc)
	{
		//print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n====>>> Executing @afterThrowing on method: " + method);
		//log the exception
		myLogger.info("\n====>>> The exception is : " + theExc);
		
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
		
		myLogger.info("\n====>>> Executing @afterReturning on method: " + method);
		
		//print the results of the method call
		myLogger.info("\n=====>>> result is: " + result);
		
		
		//tel's post-process the data.. tel's modify it :-)
		
		//convert the account name to upper case
		convertAccountNamesToUpperCase(result);
		myLogger.info("\n====>>>> result is: " + result);
		
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
		myLogger.info("\n ===>>> Executing @before advice on addAccount()");
	
		//display the method signature
		MethodSignature methodsig = (MethodSignature) theJointPoint.getSignature();
		
		//display method arguments
		myLogger.info("Method : " + methodsig);
		
		//get args
		Object[] args = theJointPoint.getArgs();
	     
		for(Object tempArg :args)
		{
			myLogger.info(tempArg.toString());
		    
			if(tempArg instanceof Account)
			{
				Account theAccount = (Account) tempArg;
				myLogger.info("account name:" + theAccount.getName());
				myLogger.info("account name:" + theAccount.getLevel());
			}
		}
	
	
	
	
	}
	
	
	
	

}
