package fazluljony;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobileDokan {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");

		User user1 = context.getBean("myuser",User.class);
		
		
		System.out.println(user1.getuser());
		
		System.out.println(user1.getmobilemodel());
		System.out.println(user1.getprice());
		
		context.close();
		
		
	}

}
