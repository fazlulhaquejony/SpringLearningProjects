package fazluljony.aop.aspect;

import org.aspectj.lang.JoinPoint;
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
