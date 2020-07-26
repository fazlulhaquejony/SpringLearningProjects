package fazluljony.aop.dao;

import org.springframework.stereotype.Component;

import fazluljony.aop.Account;

@Component
public class AccountDAO {

	
	private String name;
	private String ServiceCod;
	public void addAccount(Account theAccont, boolean vipFlag)
	{
		System.out.println(getClass()+"Doing my DB work : Adding An Account");
	}
	
	public boolean doWork()
	{
		System.out.println(getClass() + ": doWork()");
		
		return false;
	}

	public String getName() {
		
		System.out.println(getClass() + ": in getName()");
		
		return name;
	}

	public void setName(String name) {
		
		System.out.println(getClass() + ": in setName()");
		
		this.name = name;
	}

	public String getServiceCod() {
		
		System.out.println(getClass() + ": in getServiceCod()");
		
		return ServiceCod;
	}

	public void setServiceCod(String serviceCod) {
		
		System.out.println(getClass() + ": in setServiceCod()");
		
		ServiceCod = serviceCod;
	}
	
	
	
}
