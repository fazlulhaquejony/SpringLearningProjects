package fazluljony.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsynsAspect {
	
	@Before("fazluljony.aop.aspect.LuvAspectExpressions.forDaoPackageNoGetterSetter()")
	public void logToClousAsync()
	{
		System.out.println("\n====> performing Logging to cloud anlytics");
	}

}
