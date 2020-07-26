package fazluljony;

public class SpecialUser implements User {
	
	
	private XaomiMobile xaomi;
	
	
	public SpecialUser(XaomiMobile xaomi) {
		
		this.xaomi = xaomi;
	}


	public SpecialUser() {
		
	}


	@Override
	public String getuser() {
		
		return "Name is Tazwar ";
		
	}
	
	@Override
	public String getmobilemodel()
	{
		return xaomi.getmodel();
	}


	@Override
	public String getprice() {
		
		return xaomi.pricedetails();
	}


}
