package fazluljony;

import java.util.LinkedHashMap;

public class User {
	
	private String Password;
	private String userName;

	
	
	private String choice;
	private LinkedHashMap<String ,String> choiceOption;

	public User() {
		
		choiceOption = new LinkedHashMap<>();
		
		choiceOption.put("1000-2000", "1000-2000");
		choiceOption.put("3000-4000", "3000-4000");
		choiceOption.put("5000-6000", "5000-6000");
		choiceOption.put("7000-8000", "1000-2000");
		choiceOption.put("9000-10000", "9000-10000");
		
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public LinkedHashMap<String, String> getChoiceOption() {
		return choiceOption;
	}
	

	

}
