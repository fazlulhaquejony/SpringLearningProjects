package fazluljony;

public class XaomiMobile implements Mobile {
	
		
	private int price = 10;
	
	public XaomiMobile() {
	
	}

	@Override
	public String getmodel() {
		
		return "the thpne is pockophone";
	}

	@Override
	public String pricedetails() {
	     
		return "Price is"+price;
	}
	

	}
