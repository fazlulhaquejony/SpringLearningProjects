package fazluljonymvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")//parent mapping to reduce ambiguous(ospsto) mapping 
public class HelloWorldController {
	
	//need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	// new a controller method to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model)
	{
		//read request parameter from the HTML form
		
		String theName =request.getParameter("studentName");
		
		//convert the data to all capital letter
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Success! " + theName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld"; 
	}
	
	// new a controller method request mapping using annotation
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, 
			Model model)
	{
		//read request parameter from the HTML form(no need for @RequestParam )
		
		//String theName =request.getParameter("studentName");
		
		//convert the data to all capital letter
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Success for Reques annotaion! " + theName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld"; 
	}
	

}
