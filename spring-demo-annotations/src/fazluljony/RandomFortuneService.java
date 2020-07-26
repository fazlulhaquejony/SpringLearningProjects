package fazluljony;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create a Array of string
	
	private String[] data = {
			"I love my family",
			"Bulbul cyclone is comming",
			"Tomorrow my exam will held"
	};
	
	//create random no.generator
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		
		//pick a random string from the array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		
		return theFortune;
	}

}
