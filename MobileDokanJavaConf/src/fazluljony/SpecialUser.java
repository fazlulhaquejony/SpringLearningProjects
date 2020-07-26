package fazluljony;

public class SpecialUser implements User {
	
	
	private Mobile xaomi;


	public SpecialUser(Mobile xaomi) {
		
		this.xaomi = xaomi;
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
