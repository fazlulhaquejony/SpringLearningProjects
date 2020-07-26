package fazluljony;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fazluljony")
public class JavaConfigIoc {
	
	@Bean
	public Mobile mymobile()
	{
		return new XaomiMobile();
	}
	
    @Bean
	public User myuser(Mobile mobile) {
		
    	SpecialUser suser = new SpecialUser(mymobile());
    	return suser;
			
	}

}
