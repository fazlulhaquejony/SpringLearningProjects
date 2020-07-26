package com.fjtechsolutions.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup point cut declaration
	@Pointcut("execution(* com.fjtechsolutions.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same  for dao and service
	@Pointcut("execution(* com.fjtechsolutions.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.fjtechsolutions.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toLongString();
		
		//display the arguments to the method
		myLogger.info("=====>> in @Before: calling method: " + theMethod);
		
		//get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru and display args
		for(Object tempArg : args)
		{
			myLogger.info("=====>> argument: " + tempArg);
		}
	}
	
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
     public void afterReturring(JoinPoint theJoinPoint , Object theResult)
     {
		//display method we are returning from
        String theMethod = theJoinPoint.getSignature().toLongString();
		
		//display the arguments to the method
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);
		

		//display data returned
		myLogger.info("======>>>result: " + theResult);
     }
}
