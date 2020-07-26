package fazluljonymvc;
// to show if there is name name view/request mapping

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	@RequestMapping("/showForm")
	public String displayTheForm() 
	{
		return "sillymethod";
		
	}

}
