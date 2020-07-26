package fazluljonyemailapp.model;

public class EmailSender {
	
	private String to;
	private String sub;
	private String body;
	public EmailSender(String to, String sub, String body) {
		this.to = to;
		this.sub = sub;
		this.body = body;
	}
	
	public EmailSender()
	{
		
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	

}
