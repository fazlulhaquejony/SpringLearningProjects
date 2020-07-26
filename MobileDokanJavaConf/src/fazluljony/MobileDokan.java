 package fazluljony;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MobileDokan {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new  AnnotationConfigApplicationContext(JavaConfigIoc.class);

		User user1 = context.getBean("myuser",User.class);
		
		
		System.out.println(user1.getuser());
		
		System.out.println(user1.getmobilemodel());
		System.out.println(user1.getprice());
		
		context.close();
		
		
	}

}
