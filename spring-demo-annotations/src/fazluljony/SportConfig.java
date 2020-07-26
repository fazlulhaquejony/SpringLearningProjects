 package fazluljony;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("fazluljony")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//define bean for our sad fortune service
	// here sadFortuneService() at sadFortuneService is bean id
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
		
	}
	
	//define bean for our swim coach and inject dependency
	//here swimcoach is inject sadfortuneservice to swimcoach
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(sadFortuneService());
	}
}
