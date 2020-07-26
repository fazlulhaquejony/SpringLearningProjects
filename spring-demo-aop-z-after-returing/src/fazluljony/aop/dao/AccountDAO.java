package fazluljony.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fazluljony.aop.Account;

@Component
public class AccountDAO {

	
	private String name;
	private String ServiceCod;
	
	
	public List<Account>findAccounts()
	{
		List<Account> myAccounts = new ArrayList<>();
	
		Account temp1 = new Account("jony","gold");
		Account temp2 = new Account("juel","platinam");
		Account temp3 = new Account("fariha","gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
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
