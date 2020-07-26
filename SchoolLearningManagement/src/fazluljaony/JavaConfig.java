package fazluljaony;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fazluljaony")
public class JavaConfig {
	
	@Bean
	public Student mystudent()
	{
		return new ClassOneStudent();
		
	}
	
	@Bean
	public Teacher myteacher()
	{
		return new MorningTeacher(mystudent());
		
	}

}
