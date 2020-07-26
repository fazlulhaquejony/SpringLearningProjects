package fazluljony.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class LoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//let's start with an @Before advice
	
	
	
	//@Before("execution(* add*(fazluljony.aop.Account))")
	@Before("fazluljony.aop.aspect.LuvAspectExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ===>>> Executing @before advice on addAccount()");
	}
	
	
	
	

}
