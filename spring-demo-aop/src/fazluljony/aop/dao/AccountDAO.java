package fazluljony.aop.dao;

import org.springframework.stereotype.Component;

import fazluljony.aop.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccont, boolean vipFlag)
	{
		System.out.println(getClass()+"Doing my DB work : Adding An Account");
	}
	
	public boolean doWork()
	{
		System.out.println(getClass() + ": doWork");
		
		return false;
	}
}
