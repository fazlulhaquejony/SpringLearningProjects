package fazluljony;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/showform")
	public String ShowuserForm(Model model)
	{
		model.addAttribute("user", new User());
		return "user-form";
	}
	
	@RequestMapping("/Regfaield")
	public String Regfailed()
	{
		return "user-faield";
	}
	
	@RequestMapping("/showdetails")
	public String Showuserdetails()
	{
		return "user-detailshow";
	}
	private String Username = "jony";
	private String Passward = "1234";
	
	@RequestMapping("/valueProcessing")
	public String Processingdetails(@ModelAttribute("user") User theuser)
	{
		String username = theuser.getUserName();
		String password = theuser.getPassword();
		//System.out.println("Name: "+theuser.getUserName()+ "password:" + theuser.getPassword()); 
		if(username.equals(Username) && password.equals(Passward))
		{
		
			return "user-detailshow";
		}	
		return "user-faield";
	}
}
