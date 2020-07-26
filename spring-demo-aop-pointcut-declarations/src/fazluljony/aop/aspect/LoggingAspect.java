package fazluljony.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//let's start with an @Before advice
	
	
	@Pointcut("execution(* fazluljony.aop.dao.*.*(..))")
	private void forDaoPackage() {} 
	
	
	
	
	//@Before("execution(* add*(fazluljony.aop.Account))")
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ===>>> Executing @before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics()
	{
		System.out.println("\n====> performing API anlytics");
	}

}
