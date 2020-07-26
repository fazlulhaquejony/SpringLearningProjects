package fazluljony.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticAspects {
	
	@Before("fazluljony.aop.aspect.LuvAspectExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("\n====> performing API anlytics");
	}

}
