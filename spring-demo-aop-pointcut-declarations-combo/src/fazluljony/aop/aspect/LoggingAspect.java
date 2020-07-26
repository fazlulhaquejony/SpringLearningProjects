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
	
	@Pointcut("execution(* fazluljony.aop.dao.*.get*(..))")
	public void getter() {}
	
	
	@Pointcut("execution(* fazluljony.aop.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	//@Before("execution(* add*(fazluljony.aop.Account))")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ===>>> Executing @before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("\n====> performing API anlytics");
	}

}
