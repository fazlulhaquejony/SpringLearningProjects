package fazluljony;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Entered happyfortune services getfortune method!";
	}

}
