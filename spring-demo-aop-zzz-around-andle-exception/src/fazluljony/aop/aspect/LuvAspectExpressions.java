package fazluljony.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAspectExpressions {
	@Pointcut("execution(* fazluljony.aop.dao.*.*(..))")
	public void forDaoPackage() {} 
	
	@Pointcut("execution(* fazluljony.aop.dao.*.get*(..))")
	public void getter() {}
	
	
	@Pointcut("execution(* fazluljony.aop.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	

}
